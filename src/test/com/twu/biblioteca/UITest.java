package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;


public class UITest {

    private PrintStream printStream;
    private InputStream inputStream;
    private UI ui;
    private Scanner mockScanner;

    Book catch22 = new Book("Catch 22", "Joseph Heller", 1961, "REF#01");
    Book hhgttg = new Book ("Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1992, "REF#02");
    Book fMrFox = new Book ("Fantastic Mr Fox", "Roald Dahl", 1970, "REF#03");


    private TreeMap<String, MenuOption> options = new TreeMap<>();
    private BookViewer viewer = new BookViewer(ui);
    private BookReserver reserver = new BookReserver(ui);
    private BookReturner returner = new BookReturner(ui);

    OptionsMenu optionsMenu = new OptionsMenu(options, mockScanner);

    StockManager stockManager = new StockManager();


    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        mockScanner = new Scanner(System.in);
        ui = spy(new UI(printStream, mockScanner, optionsMenu));
        stockManager.clearStock();
        stockManager.addItemToStock(catch22);
        stockManager.addItemToStock(hhgttg);
        stockManager.addItemToStock(fMrFox);
        stockManager.clearReservedList();

        options.put("1 - View Books", viewer);
        options.put("2 - Reserve Book", reserver);
        options.put("3 - Return Book", returner);

    }

    @Test
    public void welcomeMessageReturnsCorrectString() {
        //when
        ui.displayWelcome();
        //then
        verify(printStream).println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n");
    }


    @Test
    public void listOfAvailableBooksDisplayedToUser(){
        //given - set-up
        List<StockType> books = stockManager.getStock();
        // when
        ui.displayBooks();
        //then
        for (StockType book : books) {
        verify(printStream).printf("%-10.10s %-40.40s %-30.30s  %-30.30s%n", book.getRef(), book.getTitle(), book.getAuthor(), book.getYear());}
    }

    @Test
    public void menuOptionsDisplayedToUser() {
        //given - set-up
        String result = "1 - View Books\n";
        //when
        ui.displayOptions();
        //then
        verify(printStream).println(result);
    }

    @Test
    public void userCanInputASelection() {
        //given
        String input = "1";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        mockScanner = new Scanner(System.in);
        ui = new UI(printStream, mockScanner, optionsMenu);
        //when
        String result = ui.getUserInput();
        //then
        assertThat(result, is("1"));
    }


    @Test
    public void checkThatGoodbyeMessageDisplaysCorrectly() {
        //given - setUp()
        //when
        ui.displayGoodbyeMessage();
        //then
        verify(printStream).println("Thank you for using Biblioteca! We look forward to seeing you again!");
    }

    @Test
    public void whenBookISReservedItIsAddedToReservedListAndRemovedFromStock() {
        //given - setUp()
        /**There are books available to be reserved**/
        //when
        String input = "REF#01";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        mockScanner = new Scanner(System.in);
        ui = new UI(printStream, mockScanner, optionsMenu);
        ui.reserveBook();
        //then
        /** the book is added to the reserved book list **/
        assertThat(stockManager.getReservedItems().size(), is(1));
        assertThat(stockManager.getReservedItems(), hasItem(catch22));
        assertThat(stockManager.getStock().size(), is(2));
        assertThat(stockManager.getStock(), not(hasItem(catch22)));

    }


    @Test
    public void whenUserReservesBookSuccessMessagePrinted() {
        //when
        String input = "REF#01";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        mockScanner = new Scanner(System.in);
        ui = new UI(printStream, mockScanner, optionsMenu);
        ui.reserveBook();
        //then
        verify(printStream).println("Thank you! Enjoy the book!");
    }

    @Test
    public void ifReserveRequestUnsuccessfulUserIsNotified() {
        //when
        String input = "unknown ref";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        mockScanner = new Scanner(System.in);
        ui = new UI(printStream, mockScanner, optionsMenu);
        ui.reserveBook();
        //then
        verify(printStream).println("Sorry, that book is not available.");
    }

    @Test
    public void ifBookReturnedItIsAddedToStockAndRemovedFromReservedList() {
        //given - setUp to add book to reserved list - this function has been tested above
        String input = "REF#01";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        mockScanner = new Scanner(System.in);
        ui = new UI(printStream, mockScanner, optionsMenu);
        ui.reserveBook();
        //when - the returnBook() method is called with the same reference as input
        String input2 = "REF#01";
        inputStream = new ByteArrayInputStream(input2.getBytes());
        System.setIn(inputStream);
        mockScanner = new Scanner(System.in);
        ui = new UI(printStream, mockScanner, optionsMenu);
        ui.returnBook();
        //then
        assertThat(stockManager.getStock().size(), is(3));
        assertThat(stockManager.getReservedItems().size(), is(0));
    }

    @Test
    public void whenUserReturnsBookSuccessMessagePrinted() {
        //given - setUp to add book to reserved list - this function has been tested above
        String input = "REF#01";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        mockScanner = new Scanner(System.in);
        ui = new UI(printStream, mockScanner, optionsMenu);
        ui.reserveBook();
        //when
        String input2 = "REF#01";
        inputStream = new ByteArrayInputStream(input2.getBytes());
        System.setIn(inputStream);
        mockScanner = new Scanner(System.in);
        ui = new UI(printStream, mockScanner, optionsMenu);
        ui.returnBook();
        //then
        verify(printStream).println("Thank you for returning the book!");
    }

    @Test
    public void ifReturnRequestUnsuccessfulUserIsNotified() {
        //when
        String input = "unknown ref";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        mockScanner = new Scanner(System.in);
        ui = new UI(printStream, mockScanner, optionsMenu);
        ui.returnBook();
        //then
        verify(printStream).println("That is not a valid book to return.");
    }


}

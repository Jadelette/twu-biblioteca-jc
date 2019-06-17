package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
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
    private UserList userList = new UserList();

    BookList bookList = new BookList();
    List<Book> booksFromDb = bookList.getBookList();

    StockManager bookStockManager = new StockManager();
    StockManager movieStockManager = new StockManager();

    private TreeMap<String, MenuOption> options = new TreeMap<>();
    OptionsMenu optionsMenu = new OptionsMenu(options, mockScanner);
    OptionsList optionsList = new OptionsList(ui, bookStockManager, movieStockManager);


    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        mockScanner = new Scanner(System.in);
        ui = spy(new UI(printStream, mockScanner, optionsMenu, userList));
        bookStockManager.clearStock();

        //add books to stock (simulate pulling from db)
        for (Book book : booksFromDb){
            bookStockManager.addItemToStock(book);
        }

        bookStockManager.clearReservedList();

        //populate list of menu options (simulate pulling from db)
        TreeMap<String, MenuOption> optionsFromDB = optionsList.getOptions();
        for (
                Map.Entry<String, MenuOption> entry : optionsFromDB.entrySet()) {
            String key = entry.getKey();
            options.put(key, optionsFromDB.get(key));
        }

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
        // when
        ui.displayStock(bookStockManager);
        //then
        verify(printStream).printf("%-40.40s", "REF01");
        verify(printStream).printf("%-40.40s", "Catch 22");
        verify(printStream).printf("%-40.40s", "Joseph Heller");
        verify(printStream).printf("%-40.40s", "1961");}


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
        ui = new UI(printStream, mockScanner, optionsMenu, userList);
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
        //There are books available to be reserved
        //when
        String input = "REF01";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        mockScanner = new Scanner(System.in);
        ui = new UI(printStream, mockScanner, optionsMenu, userList);
        ui.reserveItem(bookStockManager);
        //then
        // the book is added to the reserved list
        assertThat(bookStockManager.getReservedItems().size(), is(1));
        assertThat(bookStockManager.getReservedItems(), hasItem(booksFromDb.get(0)));
        assertThat(bookStockManager.getStock().size(), is(2));
        assertThat(bookStockManager.getStock(), not(hasItem(booksFromDb.get(0))));

    }


    @Test
    public void whenUserReservesBookSuccessMessagePrinted() {
        //when
        String input = "REF01";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        mockScanner = new Scanner(System.in);
        ui = new UI(printStream, mockScanner, optionsMenu, userList);
        ui.reserveItem(bookStockManager);
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
        ui = new UI(printStream, mockScanner, optionsMenu, userList);
        ui.reserveItem(bookStockManager);
        //then
        verify(printStream).println("Sorry, that book is not available.");
    }

    @Test
    public void ifBookReturnedItIsAddedToStockAndRemovedFromReservedList() {
        //given - setUp to add book to reserved list - this function has been tested above
        String input = "REF01";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        mockScanner = new Scanner(System.in);
        ui = new UI(printStream, mockScanner, optionsMenu, userList);
        ui.reserveItem(bookStockManager);
        //when - the returnItem() method is called with the same reference as input
        String input2 = "REF01";
        inputStream = new ByteArrayInputStream(input2.getBytes());
        System.setIn(inputStream);
        mockScanner = new Scanner(System.in);
        ui = new UI(printStream, mockScanner, optionsMenu, userList);
        ui.returnItem(bookStockManager);
        //then
        assertThat(bookStockManager.getStock().size(), is(3));
        assertThat(bookStockManager.getReservedItems().size(), is(0));
    }

    @Test
    public void whenUserReturnsBookSuccessMessagePrinted() {
        //given - setUp to add book to reserved list - this function has been tested above
        String input = "REF01";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        mockScanner = new Scanner(System.in);
        ui = new UI(printStream, mockScanner, optionsMenu, userList);
        ui.reserveItem(bookStockManager);
        //when
        String input2 = "REF01";
        inputStream = new ByteArrayInputStream(input2.getBytes());
        System.setIn(inputStream);
        mockScanner = new Scanner(System.in);
        ui = new UI(printStream, mockScanner, optionsMenu, userList);
        ui.returnItem(bookStockManager);
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
        ui = new UI(printStream, mockScanner, optionsMenu, userList);
        ui.returnItem(bookStockManager);
        //then
        verify(printStream).println("That is not a valid book to return.");
    }

    @Test
    public void userPasswordCanBeReturnedBasedOnReferenceNumber() {
        String input = "123-4567";

        String result = ui.getPasswordUsingRefNumber(input);
        //then
        assertThat(result, is ("password1"));
    }



}

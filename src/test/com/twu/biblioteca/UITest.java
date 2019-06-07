package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import static org.mockito.Mockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.And;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.Assert.assertEquals;


public class UITest {

    private PrintStream printStream;
    private InputStream inputStream;
    private UI ui;

    Book catch22 = new Book("Catch 22", "Joseph Heller", 1961);
    Book hhgttg = new Book ("Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1992);
    Book fMrFox = new Book ("Fantastic Mr Fox", "Roald Dahl", 1970);


    TreeMap<String, Method> optionsMenu = new TreeMap<>();


    @Before
    public void setUp() throws NoSuchMethodException {
        printStream = mock(PrintStream.class);
        ui = spy(new UI(printStream));
        StockManager.addBookToStock(catch22);
        StockManager.addBookToStock(hhgttg);
        StockManager.addBookToStock(fMrFox);

        optionsMenu.put("1 - View Books", UI.class.getMethod("displayBooks"));

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
        List<Book> books = StockManager.getBooksInStock();
        // when
        ui.displayBooks();
        //then
        for (Book book : books) {
        verify(printStream).printf("%-40.40s %-30.30s  %-30.30s%n", book.getTitle(), book.getAuthor(), book.getYear());}
    }

    @Test
    public void menuOptionsDisplayedToUser() throws NoSuchMethodException {
        //given - set-up
        String result = "1 - View Books\n";
        //when
        ui.displayOptions();
        //then
        verify(printStream).println(result);
    }

    @Test
    public void userCanInputASelection() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        String input = "1";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Scanner mockScanner = new Scanner(System.in);

        //when
        String result = ui.getUserInput(mockScanner);

        assertThat(result, is("1"));
    }


    @Test
    public void ifUserEntersXDisplayGoodbyeMessageIsCalled() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        //given
        String input = "x";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Scanner mockScanner = new Scanner(System.in);

        //when
        String result = ui.getUserInput(mockScanner);
        //then (check that returned input value is correct and correct method called)
        assertThat(result, is("x"));
        verify(ui).displayGoodbyeMessage();
    }

    @Test
    public void checkThatGoodbyeMessageDisplaysCorrectly() {
        //given - setUp()
        //when
        ui.displayGoodbyeMessage();
        //then
        verify(printStream).println("Thank you for using Biblioteca! We look forward to seeing you again!");
    }

}

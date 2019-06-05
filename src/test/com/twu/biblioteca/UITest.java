package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


import java.io.PrintStream;
import java.lang.reflect.Array;
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
    private UI ui;

    Book catch22 = new Book("Catch 22", "Joseph Heller", 1961);
    Book hhgttg = new Book ("Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1992);
    Book fMrFox = new Book ("Fantastic Mr Fox", "Roald Dahl", 1970);


    TreeMap<String, Method> optionsMenu = new TreeMap<>();


    @Before
    public void setUp() throws NoSuchMethodException {
        printStream = mock(PrintStream.class);
        ui = new UI(printStream);
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
        String result = "1 - View Books";
        //when
        ui.displayOptions();
        //then
        verify(printStream).println(result);
    }

}

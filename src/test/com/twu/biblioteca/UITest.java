package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;


import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import static org.mockito.Mockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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

    List<Book> books = new ArrayList<Book>();



    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        ui = new UI(printStream);

        books.add(catch22);
        books.add(hhgttg);
        books.add(fMrFox);
    }

    @Test
    public void welcomeMessageReturnsCorrectString() {
        //when
        ui.displayWelcome();
        //then
        verify(printStream).println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    @Test
    public void bookGetTitleReturnsCorrectValue() {
        //given - set-up (book details specified)
        //when
        String result = catch22.getTitle();
        //then
        assertThat(result, is("Catch 22"));
    }

    @Test
    public void bookGetAuthorReturnsCorrectValue() {
        //given - set-up (book details specified)
        //when
        String result = catch22.getAuthor();
        //then
        assertThat(result, is("Joseph Heller"));
    }

    @Test
    public void bookGetYearReturnsCorrectValue() {
        //given - set-up (book details specified)
        //when
        int result = catch22.getYear();
        //then
        assertThat(result, is(1961));
    }

    @Test
    public void listOfAvailableBooksDisplayedToUser(){
        //given - set-up
        // when
        ui.displayBooks(books);
        //then
        for (Book book : books) {
        verify(printStream).printf("%-40.40s %-30.30s  %-30.30s%n", book.getTitle(), book.getAuthor(), book.getYear());}
    }

}

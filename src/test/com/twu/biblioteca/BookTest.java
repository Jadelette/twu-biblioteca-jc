package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class BookTest {

    Book catch22 = new Book("Catch 22", "Joseph Heller", "1961", "REF#01");
    Book hhgttg = new Book("Hitchhiker's Guide to the Galaxy", "Douglas Adams", "1992", "REF#02");
    Book fMrFox = new Book("Fantastic Mr Fox", "Roald Dahl", "1970", "REF#03");


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
        String result = catch22.getYear();
        //then
        assertThat(result, is("1961"));
    }
}

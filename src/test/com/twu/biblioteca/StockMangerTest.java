package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;


import java.io.PrintStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.*;

import static org.hamcrest.CoreMatchers.hasItem;
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


public class StockMangerTest {

    Book catch22 = new Book("Catch 22", "Joseph Heller", 1961);
    Book hhgttg = new Book ("Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1992);
    Book fMrFox = new Book ("Fantastic Mr Fox", "Roald Dahl", 1970);

    @Before
    public void setUp() {
    StockManager.clearStock();
    }

    @Test
    public void ifNoBooksAddedGetBooksReturnsEmptyList() {
        //when
        List<Book> books = StockManager.getBooksInStock();
        //then
        assertThat(books.isEmpty(), is(true));
    }

    @Test
    public void checkThatBookCanBeAddedToStock() {
        //given - setup
        //when
        StockManager.addBookToStock(catch22);
        //then
        assertThat(StockManager.getBooksInStock(), hasItem(catch22));
    }


}

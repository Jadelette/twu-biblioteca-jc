package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;
import java.util.StringTokenizer;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;


public class StockMangerTest {

    Book catch22 = new Book("Catch 22", "Joseph Heller", 1961, "REF#01");
    Book hhgttg = new Book ("Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1992, "REF#02");
    Book fMrFox = new Book ("Fantastic Mr Fox", "Roald Dahl", 1970, "REF#03");

    @Before
    public void setUp() {
    StockManager.clearStock();
    StockManager.clearReservedList();
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

    @Test
    public void checkThatBookCanBeRemovedFromStock() {
        //given
        StockManager.addBookToStock(catch22);
        StockManager.addBookToStock(fMrFox);
        StockManager.addBookToStock(hhgttg);
        StockManager.addBookToReservedList("REF#01");
        //when
        StockManager.removeBookFromStock("REF#01");
        //then - super thorough test! ^_^
       // assertThat(StockManager.getBooksInStock().size(), is(2));
        assertThat(StockManager.getBooksInStock(), not(hasItem(catch22)));
        assertThat(StockManager.getBooksInStock(), hasItem(fMrFox));
        assertThat(StockManager.getBooksInStock(), hasItem(hhgttg));
    }

    @Test
    public void ifNoItemsReservedGetReservedMethodReturnsEmptyList() {
        //given - setUp
        //when
        List<Book> result = StockManager.getReservedBooks();
        //then
        assertThat(result.size(), is(0));
    }

    @Test
    public void checkThatBookCanBeAddedToReservedBookList() {
        //given - setUp
        StockManager.addBookToStock(catch22);
        StockManager.addBookToStock(fMrFox);
        StockManager.addBookToStock(hhgttg);
        //when
        StockManager.addBookToReservedList("REF#01");
        //then
        assertThat(StockManager.getReservedBooks(), hasItem(catch22));
    }
}

package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;


public class StockMangerTest {

    Book catch22 = new Book("Catch 22", "Joseph Heller", "1961", "REF#01");
    Book hhgttg = new Book ("Hitchhiker's Guide to the Galaxy", "Douglas Adams", "1992", "REF#02");
    Book fMrFox = new Book ("Fantastic Mr Fox", "Roald Dahl", "1970", "REF#03");

    StockManager stockManager = new StockManager();

    @Before
    public void setUp() {
    stockManager.clearStock();
    stockManager.clearReservedList();
    }

    @Test
    public void ifNoItemsAddedGetItemsReturnsEmptyList() {
        //when
        ArrayList<StockType> books = stockManager.getStock();
        //then
        assertThat(books.isEmpty(), is(true));
    }

    @Test
    public void checkThatItemCanBeAddedToStock() {
        //given - setup
        //when
        stockManager.addItemToStock(catch22);
        //then
        assertThat(stockManager.getStock(), hasItem(catch22));
    }

    @Test
    public void checkThatItemCanBeRemovedFromStock() {
        //given
        stockManager.addItemToStock(catch22);
        stockManager.addItemToStock(fMrFox);
        stockManager.addItemToStock(hhgttg);
        stockManager.addItemToReservedList("REF#01");
        //when
        stockManager.removeItemFromStock("REF#01");
        //then - super thorough test! ^_^
        assertThat(stockManager.getStock().size(), is(2));
        assertThat(stockManager.getStock(), not(hasItem(catch22)));
        assertThat(stockManager.getStock(), hasItem(fMrFox));
        assertThat(stockManager.getStock(), hasItem(hhgttg));
    }

    @Test
    public void ifNoItemsReservedGetReservedMethodReturnsEmptyList() {
        //given - setUp
        //when
        List<StockType> result = stockManager.getReservedItems();
        //then
        assertThat(result.size(), is(0));
    }

    @Test
    public void ItemCanBeAddedToReservedList() {
        //given - setUp
        stockManager.addItemToStock(catch22);
        stockManager.addItemToStock(fMrFox);
        stockManager.addItemToStock(hhgttg);
        //when
        stockManager.addItemToReservedList("REF#01");
        //then
        assertThat(stockManager.getReservedItems(), hasItem(catch22));
    }

    @Test
    public void ItemCanBeRemovedFromReservedList() {
        //given
        stockManager.addItemToStock(catch22);
        stockManager.addItemToStock(fMrFox);
        stockManager.addItemToStock(hhgttg);
        stockManager.addItemToReservedList("REF#01");
        stockManager.addItemToReservedList("REF#02");
        stockManager.addItemToReservedList("REF#03");
        //when
        stockManager.removeItemFromReservedList("REF#01");
        //then - super thorough test! ^_^
        assertThat(stockManager.getReservedItems().size(), is(2));
        assertThat(stockManager.getReservedItems(), not(hasItem(catch22)));
        assertThat(stockManager.getReservedItems(), hasItem(fMrFox));
        assertThat(stockManager.getReservedItems(), hasItem(hhgttg));
    }

    @Test
    public void ItemCanBeReturnedToStock() {
        //given - setUp
        stockManager.addItemToStock(catch22);
        stockManager.addItemToStock(fMrFox);
        stockManager.addItemToStock(hhgttg);
        stockManager.addItemToReservedList("REF#01");
        stockManager.addItemToReservedList("REF#02");
        stockManager.addItemToReservedList("REF#03");
        //when
        stockManager.returnItemToStock("REF#01");
        //then
        assertThat(stockManager.getStock(), hasItem(catch22));
    }
}

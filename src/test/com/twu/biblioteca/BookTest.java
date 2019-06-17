package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class BookTest {

    Book catch22 = new Book("Catch 22", "Joseph Heller", "1961", "REF01");

  @Test

    public void bookGetRefReturnsCorrectValue() {
        //given - set-up (book details specified)
        //when
        String result = catch22.getRef();
        //then
        assertThat(result, is("REF01"));
    }

    @Test
    public void bookGetProductInfoReturnsDetailsAboutBook() {
        //given - set-up (book details specified)
        //when
        LinkedHashMap<String, String> bookInfo = catch22.getProductInfo();
        //then
        assertThat(bookInfo.get("Reference"), is ("REF01"));
        assertThat(bookInfo.get("Title"), is ("Catch 22"));
        assertThat(bookInfo.get("Author"), is ("Joseph Heller"));
        assertThat(bookInfo.get("Year"), is ("1961"));
    }

    @Test
    public void bookGetTypeReturnsBook() {
        //given - set-up (book details specified)
        //when
        String result = catch22.getType();
        //then
        assertThat(result, is("book"));
    }




}

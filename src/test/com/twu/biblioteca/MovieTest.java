package com.twu.biblioteca;


import org.junit.Test;

import java.util.LinkedHashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class MovieTest {

    Movie darkCrystal = new Movie("The Dark Crystal", "1982", "Jim Henson", "8/10", "REF01");

  @Test

    public void movieGetRefReturnsCorrectValue() {
        //given - set-up (book details specified)
        //when
        String result = darkCrystal.getRef();
        //then
        assertThat(result, is("REF01"));
    }

    @Test
    public void bookGetProductInfoReturnsDetailsAboutBook() {
        //given - set-up (book details specified)
        //when
        LinkedHashMap<String, String> bookInfo = darkCrystal.getProductInfo();
        //then
        assertThat(bookInfo.get("Reference"), is ("REF01"));
        assertThat(bookInfo.get("Name"), is ("The Dark Crystal"));
        assertThat(bookInfo.get("Director"), is ("Jim Henson"));
        assertThat(bookInfo.get("Year"), is ("1982"));
        assertThat(bookInfo.get("Rating"), is ("8/10"));
    }

    @Test
    public void bookGetTypeReturnsBook() {
        //given - set-up (book details specified)
        //when
        String result = darkCrystal.getType();
        //then
        assertThat(result, is("movie"));
    }




}

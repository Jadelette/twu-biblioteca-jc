package com.twu.biblioteca;

import java.util.LinkedHashMap;

public class Book implements StockType {

    private LinkedHashMap<String, String> productInfo = new LinkedHashMap<>();

    private String title;
    private String author;
    private String year;
    private String reference;

    public Book(String title, String author, String year, String reference) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.reference = reference;

        productInfo.put("Reference", reference);
        productInfo.put("Title", title);
        productInfo.put("Author", author);
        productInfo.put("Year", year);
    }


    public String getTitle() {
        return title;
    }


    public String getAuthor() {
        return author;
    }


    public String getYear() { return year; }


    public String getRef(){
        return reference;
    }

    @Override
    public LinkedHashMap<String, String> getProductInfo() {
        return productInfo;
    }
}
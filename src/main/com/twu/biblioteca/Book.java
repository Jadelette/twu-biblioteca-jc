package com.twu.biblioteca;

public class Book implements StockType {

    private String title;
    private String author;
    private int year;
    private String reference;

    public Book(String title, String author, int year, String reference) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.reference = reference;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public String getRef(){
        return reference;
    }
}
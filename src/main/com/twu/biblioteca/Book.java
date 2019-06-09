package com.twu.biblioteca;

public class Book {

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

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getRef(){
        return reference;
    }
}
package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BookList {

    private List<Book> bookList = new ArrayList<>();

    public BookList() {
        Book catch22 = new Book("Catch 22", "Joseph Heller", "1961", "REF01");
        Book hhgttg = new Book("Hitchhiker's Guide to the Galaxy", "Douglas Adams", "1992", "REF02");
        Book fMrFox = new Book("Fantastic Mr Fox", "Roald Dahl", "1970", "REF03");

        bookList.add(catch22);
        bookList.add(hhgttg);
        bookList.add(fMrFox);
    }

    public List<Book> getBookList() {
        return bookList;
    }
}

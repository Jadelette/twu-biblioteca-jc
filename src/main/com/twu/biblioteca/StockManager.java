package com.twu.biblioteca;

import org.omg.CORBA.Object;

import java.util.ArrayList;
import java.util.List;

public class StockManager {

    private static List<Book> booksInStock = new ArrayList<>();

    public static List<Book>getBooksInStock() {
        return booksInStock;
    }

    public static void addBookToStock(Book book) {
        booksInStock.add(book);
    }

    public static void clearStock() {
        booksInStock = new ArrayList<>();
    }

}

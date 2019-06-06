package com.twu.biblioteca;

import org.omg.CORBA.Object;

import java.util.ArrayList;
import java.util.List;

// TODO this is ok for now but if this was a bigger project, you should sparingly make things
//      static as it means they cant be reused later
public class StockManager {

    // TODO this is a good use of generics, instead of making the type ArrayList on the left hand side
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

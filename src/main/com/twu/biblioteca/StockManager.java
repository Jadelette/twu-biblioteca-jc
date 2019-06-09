package com.twu.biblioteca;

import org.omg.CORBA.Object;

import java.util.ArrayList;
import java.util.List;

public class StockManager {

    private static List<Book> booksInStock = new ArrayList<>();
    private static List<Book> reservedBooks = new ArrayList<>();

    public static List<Book>getBooksInStock() {
        return booksInStock;
    }

    public static void addBookToStock(Book book) {
        booksInStock.add(book);
    }
    
    public static void removeBookFromStock(String bookRef) {
        for (Book book : reservedBooks) {
            if (book.getRef().contains(bookRef)){
                booksInStock.remove(book);
            }
        }
    }

    public static List<Book> getReservedBooks(){
        return reservedBooks;
    }

    public static void addBookToReservedList(String bookRef){
        for (Book book : booksInStock) {
            if (book.getRef().contains(bookRef)) {
                reservedBooks.add(book);
            }
        }
    }

    public static void clearStock() {
        booksInStock = new ArrayList<>();
    }

    public static void clearReservedList() {
        reservedBooks = new ArrayList<>();
    }
}

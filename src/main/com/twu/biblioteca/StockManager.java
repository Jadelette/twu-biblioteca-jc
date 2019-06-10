package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
        Book bookToReserve = null;
        for (Book book : booksInStock) {
            if (book.getRef().equals(bookRef)) {
                bookToReserve = book;
            }
        }
        if (bookToReserve == null) {throw new InputMismatchException();
            } else {
            reservedBooks.add(bookToReserve);
        }
    }

    public static void removeBookFromReservedList(String bookRef) {
        for (Book book : booksInStock) {
            if (book.getRef().contains(bookRef)){
                reservedBooks.remove(book);
            }
        }
    }

    public static void returnBookToStock(String bookRef){
        Book bookToReturn = null;
        for (Book book : reservedBooks) {
            if (book.getRef().equals(bookRef)) {
                bookToReturn = book;
            }
        }
        if (bookToReturn == null) {throw new InputMismatchException();
        } else {
            booksInStock.add(bookToReturn);
        }
    }



    public static void clearStock() {
        booksInStock = new ArrayList<>();
    }

    public static void clearReservedList() {
        reservedBooks = new ArrayList<>();
    }



}

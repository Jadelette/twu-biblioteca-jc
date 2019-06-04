package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class UI {

    private PrintStream printStream;

    public UI(PrintStream printStream) {
        this.printStream = printStream;
    }


    public void displayWelcome() {
        printStream.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void displayBooks(List<Book> books) {
        for (Book book : books) {
            printStream.printf("%-40.40s %-30.30s  %-30.30s%n", book.getTitle(), book.getAuthor(), book.getYear());
        }
    }
}

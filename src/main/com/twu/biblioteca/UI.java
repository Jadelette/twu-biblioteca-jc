package com.twu.biblioteca;

import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class UI {

    private PrintStream printStream;
    //private TreeMap<String, Method> optionsMenu;


    public UI(PrintStream printStream) {
        this.printStream = printStream;

    }


    public void displayWelcome() {
        printStream.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n");
    }

    public void displayBooks() {
        List<Book> books = StockManager.getBooksInStock();
        for (Book book : books) {
            printStream.printf("%-40.40s %-30.30s  %-30.30s%n", book.getTitle(), book.getAuthor(), book.getYear());
        }
    }

    public void displayOptions() throws NoSuchMethodException {
        TreeMap<String, Method> optionsMenu = OptionsMenu.getOptionsMenu();
        for (String option : optionsMenu.keySet()) {
        printStream.println(option);}
    }
}

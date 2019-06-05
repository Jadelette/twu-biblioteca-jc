package com.twu.biblioteca;

import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class UI {

    private PrintStream printStream;
   // private Scanner scanner;




    public UI(PrintStream printStream) {
        this.printStream = printStream;
        //this.scanner = scanner;

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
        printStream.println(option + "\n");}
    }


    public String askForUserChoice(Scanner scanner) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        printStream.println("Menu");
        displayOptions();
        printStream.println("Type the corresponding number to select a menu option: ");

        String input = scanner.nextLine();
        printStream.println("You selected option: " + input);

        return input;
    }


}

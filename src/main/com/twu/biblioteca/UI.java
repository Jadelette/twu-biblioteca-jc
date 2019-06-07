package com.twu.biblioteca;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class UI {

    private PrintStream printStream;
    TreeMap<String, Method> optionsMenu;
    private Scanner scanner;


    public UI(PrintStream printStream, Scanner scanner) throws NoSuchMethodException {
        this.printStream = printStream;
        this.scanner = scanner;
        optionsMenu = OptionsMenu.getOptionsMenu();
    }


    public void displayWelcome() {
        printStream.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n");
    }

    public void displayBooks() {
        List<Book> books = StockManager.getBooksInStock();
        printStream.println("The following books are available to borrow:");
        for (Book book : books) {
            printStream.printf("%-40.40s %-30.30s  %-30.30s%n", book.getTitle(), book.getAuthor(), book.getYear());
        }
    }

    public void displayOptions() throws NoSuchMethodException {
        printStream.println("Menu");
        for (String option : optionsMenu.keySet()) {
        printStream.println(option + "\n");}
        printStream.println("Type the corresponding number to select a menu option, or type 'x' to exit: ");
    }


    public String getUserInput()  {
        String input;
        input = scanner.nextLine();
        return input;
    }

    public void displayGoodbyeMessage(){
        printStream.println("Thank you for using Biblioteca! We look forward to seeing you again!");
    }

}

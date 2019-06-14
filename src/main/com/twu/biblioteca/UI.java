package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class UI {

    private PrintStream printStream;
    private Scanner scanner;
    private OptionsMenu optionsMenu;
    private StockManager stockManager = new StockManager();


    public UI(PrintStream printStream, Scanner scanner, OptionsMenu optionsMenu) {
        this.printStream = printStream;
        this.scanner = scanner;
        this.optionsMenu = optionsMenu;
    }


    public void displayWelcome() {
        printStream.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n");
    }

    public void displayBooks() {
        List<StockType> books = stockManager.getStock();
        printStream.println("The following books are available to borrow:");
        for (StockType book : books) {
            printStream.printf("%-10.10s %-40.40s %-30.30s  %-30.30s%n", book.getRef(), book.getTitle(), book.getAuthor(), book.getYear());
        }
    }

    public void displayOptions()  {
        printStream.println("Menu");
        TreeMap<String, MenuOption> options = optionsMenu.getOptionsMenu();
        for (String option : options.keySet()) {
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

    public void reserveBook() {
        printStream.println("Please type the id for the book you would like to reserve:");
        String input = getUserInput();
        try {
        stockManager.addItemToReservedList(input);
        printStream.println("Thank you! Enjoy the book!");}
        catch (Exception e) {
            printStream.println("Sorry, that book is not available.");
        }
        stockManager.removeItemFromStock(input);
    }

    public void returnBook() {
        printStream.println("Please type the id for the book you would like to return:");
        String input = getUserInput();
        try {
            stockManager.returnItemToStock(input);
            printStream.println("Thank you for returning the book!");}
        catch (Exception e) {
            printStream.println("That is not a valid book to return.");
        }
        stockManager.removeItemFromReservedList(input);
    }

}



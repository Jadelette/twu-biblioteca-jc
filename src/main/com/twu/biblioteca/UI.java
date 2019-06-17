package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.*;

public class UI {

    private PrintStream printStream;
    private Scanner scanner;
    private OptionsMenu optionsMenu;
    //private StockManager stockManager;


    public UI(PrintStream printStream, Scanner scanner, OptionsMenu optionsMenu) {
        this.printStream = printStream;
        this.scanner = scanner;
        this.optionsMenu = optionsMenu;
        //this.stockManager = stockManager;
    }


    public void displayWelcome() {
        printStream.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n");
    }

    public void displayStock(StockManager stockManager) {
        ArrayList<StockType> stockList = stockManager.getStock();
        printStream.println("The following books are available to borrow:");
        for (StockType item : stockList) {
            LinkedHashMap<String, String> productInfo = item.getProductInfo();
            for (String infoItem : productInfo.keySet()) {
                printStream.printf("%-40.40s", productInfo.get(infoItem));
            }
            System.out.println(" ");
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

    public void reserveItem(StockManager stockManager) {
        String type = stockManager.determineStockType();
        printStream.println("Please type the id for the " + type + " you would like to reserve:");
        String input = getUserInput();
        try {
        stockManager.addItemToReservedList(input);
        printStream.println("Thank you! Enjoy the " + type +"!");}
        catch (Exception e) {
            printStream.println("Sorry, that " + type + " is not available.");
        }
        stockManager.removeItemFromStock(input);
    }

    public void returnItem(StockManager stockManager) {
        String type = stockManager.determineStockType();
        printStream.println("Please type the id for the " + type + " you would like to return:");
        String input = getUserInput();
        try {
            stockManager.returnItemToStock(input);
            printStream.println("Thank you for returning the " + type + "!");}
        catch (Exception e) {
            printStream.println("That is not a valid " + type + " to return.");
        }
        stockManager.removeItemFromReservedList(input);
    }


}



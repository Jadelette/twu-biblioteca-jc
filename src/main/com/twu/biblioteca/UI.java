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





    public UI(PrintStream printStream) throws NoSuchMethodException {
        this.printStream = printStream;
        optionsMenu = OptionsMenu.getOptionsMenu();
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
        for (String option : optionsMenu.keySet()) {
        printStream.println(option + "\n");}
    }

    private ArrayList<String> generateListOfMenuNumbers() {
        Set<String> options = optionsMenu.keySet();
        ArrayList<String> optionNumbers = new ArrayList<>();
        for (String option : options) {
            char temp = option.charAt(0);
            optionNumbers.add(Character.toString(temp));
        }
        return optionNumbers;
    }


    public String askForUserChoice(Scanner scanner) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<String> optionNumbers = generateListOfMenuNumbers();
        Boolean proceed = false;
        String input;
            printStream.println("Menu");
            displayOptions();
            printStream.println("Type the corresponding number to select a menu option: ");
            do {
                input = scanner.nextLine();
                if (input.equals("q")) {
                    displayGoodbyeMessage();
                    return input;
                } else if (optionNumbers.contains(input)) {
                proceed = true;
                }else {
                    printStream.println("Please select a valid option and try again");
                }
            } while (proceed == false);
        return input;
    }

    public void displayGoodbyeMessage(){
        printStream.println("Thank you for using Biblioteca! We look forward to seeing you again!");
    }

}

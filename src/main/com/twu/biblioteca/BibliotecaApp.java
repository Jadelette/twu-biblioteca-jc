package com.twu.biblioteca;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class BibliotecaApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TreeMap<String, MenuOption> options = new TreeMap<>();
        OptionsMenu optionsMenu = new OptionsMenu(options, scanner);
        UI ui = new UI(System.out, scanner, optionsMenu);
        BookViewer viewer = new BookViewer(ui);
        BookReserver reserver = new BookReserver(ui);
        BookReturner returner = new BookReturner(ui);

        options.put("1 - View Books", viewer);
        options.put("2 - Reserve Book", reserver);
        options.put("3 - Return Book", returner);


        Book catch22 = new Book("Catch 22", "Joseph Heller", 1961, "REF01");
        Book hhgttg = new Book("Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1992, "REF02");
        Book fMrFox = new Book("Fantastic Mr Fox", "Roald Dahl", 1970, "REF03");

        StockManager stockManager = new StockManager();

        stockManager.addItemToStock(catch22);
        stockManager.addItemToStock(hhgttg);
        stockManager.addItemToStock(fMrFox);

        ui.displayWelcome();

        ui.displayOptions();

        boolean proceed = true;
        while (proceed == true) {
            String input = ui.getUserInput();
            proceed = optionsMenu.invokeMenuOption(ui, input);
            }

        }
    }


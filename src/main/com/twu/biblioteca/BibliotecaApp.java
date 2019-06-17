package com.twu.biblioteca;

import java.util.*;

public class BibliotecaApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TreeMap<String, MenuOption> options = new TreeMap<>();
        OptionsMenu optionsMenu = new OptionsMenu(options, scanner);
        StockManager bookStockManager = new StockManager();
        StockManager movieStockManager = new StockManager();

        UI ui = new UI(System.out, scanner, optionsMenu);

        Viewer bookViewer = new Viewer(ui, bookStockManager);
        Reserver bookReserver = new Reserver(ui, bookStockManager);
        Returner bookReturner = new Returner(ui, bookStockManager);
        Viewer movieViewer = new Viewer(ui, movieStockManager);
        Reserver movieReserver = new Reserver(ui, movieStockManager);
        Returner movieReturner = new Returner(ui, movieStockManager);

        options.put("1 - View Books", bookViewer);
        options.put("2 - Reserve Book", bookReserver);
        options.put("3 - Return Book", bookReturner);
        options.put("4 - View Movies", movieViewer);
        options.put("5 - Reserve Movie", movieReserver);
        options.put("6 - Return Movie", movieReturner);


        Book catch22 = new Book("Catch 22", "Joseph Heller", "1961", "REF01");
        Book hhgttg = new Book("Hitchhiker's Guide to the Galaxy", "Douglas Adams", "1992", "REF02");
        Book fMrFox = new Book("Fantastic Mr Fox", "Roald Dahl", "1970", "REF03");
        bookStockManager.addItemToStock(catch22);
        bookStockManager.addItemToStock(hhgttg);
        bookStockManager.addItemToStock(fMrFox);

        Movie darkCrystal = new Movie("The Dark Crystal", "1982", "Jim Henson", "8/10", "REF01");
        Movie MIB = new Movie("Men in Black", "1997", "Barry Sonnenfeld", "7/10", "REF02");
        movieStockManager.addItemToStock(darkCrystal);
        movieStockManager.addItemToStock(MIB);


        ui.displayWelcome();

        ui.displayOptions();

        boolean proceed = true;
        while (proceed == true) {
            String input = ui.getUserInput();
            proceed = optionsMenu.invokeMenuOption(ui, input);
            }

        }
    }


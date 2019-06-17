package com.twu.biblioteca;

import java.util.Scanner;
import java.util.TreeMap;

public class OptionsList {

    private TreeMap<String, MenuOption> options = new TreeMap<>();

    public OptionsList(UI ui, StockManager bookStockManager, StockManager movieStockManager) {


        Viewer bookViewer = new Viewer(ui, bookStockManager);
        Reserver bookReserver = new Reserver(ui, bookStockManager);
        Returner bookReturner = new Returner(ui, bookStockManager);
        Viewer movieViewer = new Viewer(ui, movieStockManager);
        Reserver movieReserver = new Reserver(ui, movieStockManager);
        Returner movieReturner = new Returner(ui, movieStockManager);


        options.put("1 - View Available Books", bookViewer);
        options.put("2 - View My Books", bookViewer);
        options.put("3 - Reserve Book", bookReserver);
        options.put("4 - Return Book", bookReturner);
        options.put("5 - View Available Movies", movieViewer);
        options.put("6 - View My Movies", movieViewer);
        options.put("7 - Reserve Movie", movieReserver);
        options.put("8 - Return Movie", movieReturner);
        options.put("9 - View My Profile", movieViewer);
    }

    public TreeMap<String, MenuOption> getOptions() {
        return options;
    }
}

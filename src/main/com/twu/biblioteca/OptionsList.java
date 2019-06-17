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


        options.put("1 - View Books", bookViewer);
        options.put("2 - Reserve Book", bookReserver);
        options.put("3 - Return Book", bookReturner);
        options.put("4 - View Movies", movieViewer);
        options.put("5 - Reserve Movie", movieReserver);
        options.put("6 - Return Movie", movieReturner);
    }

    public TreeMap<String, MenuOption> getOptions() {
        return options;
    }
}

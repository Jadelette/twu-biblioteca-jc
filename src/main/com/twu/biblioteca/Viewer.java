package com.twu.biblioteca;

public class Viewer implements MenuOption {

    UI ui;
    StockManager stockManager;

    public Viewer(UI ui, StockManager stockManager) {
        this.ui = ui;
        this.stockManager = stockManager;
    }

    @Override
    public void execute(){
        ui.displayStock(stockManager);
    }
}

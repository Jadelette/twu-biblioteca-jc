package com.twu.biblioteca;

public class Returner implements MenuOption {

    UI ui;
    StockManager stockManager;


    public Returner(UI ui, StockManager stockManager) {
        this.ui = ui;
        this.stockManager = stockManager;
    }

    @Override
    public void execute() {
        ui.returnItem(stockManager);
    }
}

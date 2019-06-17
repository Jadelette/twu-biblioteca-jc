package com.twu.biblioteca;

public class Reserver implements MenuOption {

    UI ui;
    StockManager stockManager;

    public Reserver(UI ui, StockManager stockManager) {
        this.ui = ui;
        this.stockManager = stockManager;
    }

    @Override
    public void execute(){
        ui.reserveItem(stockManager);
    }
}

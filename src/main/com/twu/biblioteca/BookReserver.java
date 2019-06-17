package com.twu.biblioteca;

public class BookReserver implements MenuOption {

    UI ui;
    StockManager stockManager;

    public BookReserver(UI ui, StockManager stockManager) {
        this.ui = ui;
        this.stockManager = stockManager;
    }

    @Override
    public void execute(){
        ui.reserveBook(stockManager);
    }
}

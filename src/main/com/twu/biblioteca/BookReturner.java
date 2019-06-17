package com.twu.biblioteca;

public class BookReturner implements MenuOption {

    UI ui;
    StockManager stockManager;


    public BookReturner(UI ui, StockManager stockManager) {
        this.ui = ui;
        this.stockManager = stockManager;
    }

    @Override
    public void execute() {
        ui.returnBook(stockManager);
    }
}

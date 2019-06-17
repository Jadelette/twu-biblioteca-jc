package com.twu.biblioteca;

public class BookViewer extends StockManager implements MenuOption {

    UI ui;
    StockManager stockManager;

    public BookViewer(UI ui, StockManager stockManager) {
        this.ui = ui;
        this.stockManager = stockManager;
    }

    @Override
    public void execute(){
        ui.displayBooks(stockManager);
    }
}

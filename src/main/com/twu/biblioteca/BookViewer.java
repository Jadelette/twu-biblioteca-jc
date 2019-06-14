package com.twu.biblioteca;

public class BookViewer extends StockManager implements MenuOption {

    UI ui;

    public BookViewer(UI ui) {
        this.ui = ui;
    }

    @Override
    public void execute(){
        ui.displayBooks();
    }
}

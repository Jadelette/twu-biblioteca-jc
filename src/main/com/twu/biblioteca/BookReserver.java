package com.twu.biblioteca;

public class BookReserver implements MenuOption {

    UI ui;

    public BookReserver(UI ui) {
        this.ui = ui;
    }

    @Override
    public void execute(){
        ui.reserveBook();
    }
}

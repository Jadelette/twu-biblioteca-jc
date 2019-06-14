package com.twu.biblioteca;

public class BookReturner implements MenuOption {

    UI ui;

    public BookReturner(UI ui) {
        this.ui = ui;
    }

    @Override
    public void execute() {
        ui.returnBook();
    }
}

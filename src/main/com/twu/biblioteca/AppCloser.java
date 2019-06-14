package com.twu.biblioteca;

public class AppCloser implements MenuOption {
    UI ui;

    public AppCloser(UI ui) {
        this.ui = ui;
    }

    @Override
    public void execute() {
        ui.displayGoodbyeMessage();
    }
}

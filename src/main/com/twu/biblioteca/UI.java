package com.twu.biblioteca;

import java.io.PrintStream;

public class UI {

    private PrintStream printStream;

    public UI(PrintStream printStream) {
        this.printStream = printStream;
    }


    public void displayWelcome() {
        printStream.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
}

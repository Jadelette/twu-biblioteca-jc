package com.twu.biblioteca;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class BibliotecaApp {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Scanner scanner = new Scanner(System.in);
        UI ui = new UI(System.out, scanner);

        Book catch22 = new Book("Catch 22", "Joseph Heller", 1961, "REF#01");
        Book hhgttg = new Book("Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1992, "REF#02");
        Book fMrFox = new Book("Fantastic Mr Fox", "Roald Dahl", 1970, "REF#03");

        StockManager.addBookToStock(catch22);
        StockManager.addBookToStock(hhgttg);
        StockManager.addBookToStock(fMrFox);

        ui.displayWelcome();
        ui.displayOptions();
        boolean proceed = true;
        while (proceed == true) {
            String input = ui.getUserInput();
            proceed = OptionsMenu.invokeMenuOption(ui, input);
            }

        }
    }


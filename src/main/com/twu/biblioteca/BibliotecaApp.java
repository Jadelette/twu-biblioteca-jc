package com.twu.biblioteca;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class BibliotecaApp {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Scanner scanner = new Scanner(System.in);
        UI ui = new UI(System.out);

        Book catch22 = new Book("Catch 22", "Joseph Heller", 1961);
        Book hhgttg = new Book ("Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1992);
        Book fMrFox = new Book ("Fantastic Mr Fox", "Roald Dahl", 1970);

        StockManager.addBookToStock(catch22);
        StockManager.addBookToStock(hhgttg);
        StockManager.addBookToStock(fMrFox);

        ui.displayWelcome();

        OptionsMenu.invokeMenuOption(ui, scanner);

    }
}

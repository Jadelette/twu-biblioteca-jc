package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {

        UI ui = new UI(System.out);

        Book catch22 = new Book("Catch 22", "Joseph Heller", 1961);
        Book hhgttg = new Book ("Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1992);
        Book fMrFox = new Book ("Fantastic Mr Fox", "Roald Dahl", 1970);

        List<Book> books = new ArrayList<Book>();
        books.add(catch22);
        books.add(hhgttg);
        books.add(fMrFox);


        ui.displayWelcome();
        ui.displayBooks(books);
    }
}

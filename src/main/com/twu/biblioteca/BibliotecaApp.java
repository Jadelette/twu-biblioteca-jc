package com.twu.biblioteca;

import java.util.*;

public class BibliotecaApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TreeMap<String, MenuOption> options = new TreeMap<>();
        OptionsMenu optionsMenu = new OptionsMenu(options, scanner);

        //Generates list of users to simulate pulling from database
        UserList userList = new UserList();

        UI ui = new UI(System.out, scanner, optionsMenu, userList);

        StockManager bookStockManager = new StockManager();
        StockManager movieStockManager = new StockManager();

        //Generates a list of options to simulate pulling from database
        OptionsList optionsList = new OptionsList(ui, bookStockManager, movieStockManager);
        TreeMap<String, MenuOption> optionsFromDB = optionsList.getOptions();
        for (Map.Entry<String, MenuOption> entry : optionsFromDB.entrySet()) {
            String key = entry.getKey();
            options.put(key, optionsFromDB.get(key));
        }
        //Generates a list of books to simulate pulling from database
        BookList bookList = new BookList();
        List<Book> booksFromDb = bookList.getBookList();
        for (Book book : booksFromDb){
            bookStockManager.addItemToStock(book);
        }
        //Generates a list of Movies to simulate pulling form database
        MovieList movieList = new MovieList();
        List<Movie> moviesFromDb = movieList.getMovieList();
        for (Movie movie : moviesFromDb){
            movieStockManager.addItemToStock(movie);
        }

        //actual main method
        ui.displayWelcome();

        boolean loggedIn = false;
        while (loggedIn == false){
        loggedIn = ui.checkUserLogin();}

        ui.displayOptions();



        boolean proceed = true;
        while (proceed == true) {
            String input = ui.getUserInput();
            proceed = optionsMenu.invokeMenuOption(ui, input);
            }

        }
    }


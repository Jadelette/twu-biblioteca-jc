package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;


public class OptionsMenuTest {
    private Scanner scanner;
    private UI ui;
    private PrintStream printStream;
    private TreeMap<String, MenuOption> options = new TreeMap<>();
    private UserList userList = new UserList();

    OptionsMenu optionsMenu = new OptionsMenu(options, scanner);
    StockManager bookStockManager = new StockManager();
    StockManager movieStockManager = new StockManager();


    @Before
    public void setUp() {
        scanner = new Scanner(System.in);
        printStream = mock(PrintStream.class);
        ui = spy(new UI(printStream, scanner, optionsMenu, userList));
        OptionsList optionsList = new OptionsList(ui, bookStockManager, movieStockManager);
        TreeMap<String, MenuOption> optionsFromDB = optionsList.getOptions();
        for (Map.Entry<String, MenuOption> entry : optionsFromDB.entrySet()) {
            String key = entry.getKey();
            options.put(key, optionsFromDB.get(key));
        }

    }


    @Test
    public void checkThatGetOptionsMenuReturnsPopulatedMenu() {
        //when
        TreeMap<String, MenuOption> result = optionsMenu.getOptions();
        //then
        assertThat(result.keySet(), hasItem("1 - View Books"));
    }

    @Test
    public void checkThatSystemExitsIfUserChoosesX() {
        //given a scanner input
        String input = "x";

        //when invokeMethod is called
        boolean result = optionsMenu.invokeMenuOption(ui, input);

        //check that correct value is returned to stop loop in main
        assertThat(result, is(false));
        verify(ui).displayGoodbyeMessage();
    }

    @Test
    //cannot verify print statements beyond user choice/invoke method call?
    public void checkThatSystemInvokesCorrectMethodBasedOnUserChoice() {
        //given a scanner input
        String input= "1";

        //when invokeMethod is called
        optionsMenu.invokeMenuOption(ui,input);

        //Then the output is as expected depending on the method/option chosen by tbe user
        verify(ui).displayStock(bookStockManager);
    }

}

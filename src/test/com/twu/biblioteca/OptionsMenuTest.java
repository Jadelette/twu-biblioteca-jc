package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
    private BookViewer viewer;
    private BookReserver reserver;
    private BookReturner returner;

    OptionsMenu optionsMenu = new OptionsMenu(options, scanner);

    @Before
    public void setUp() {
        scanner = new Scanner(System.in);
        printStream = mock(PrintStream.class);
        ui = spy(new UI(printStream, scanner, optionsMenu));
        viewer = new BookViewer(ui);
        reserver = new BookReserver(ui);
        returner = new BookReturner(ui);


        options.put("1 - View Books", viewer);
        options.put("2 - Reserve Book", reserver);
        options.put("3 - Return Book", returner);
    }


    @Test
    public void checkThatGetOptionsMenuReturnsPopulatedMenu() {
        //when
        TreeMap<String, MenuOption> result = optionsMenu.getOptionsMenu();
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
        verify(ui).displayBooks();
    }

}

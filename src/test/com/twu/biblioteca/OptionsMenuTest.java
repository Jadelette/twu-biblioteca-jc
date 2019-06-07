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

    @Before
    public void setUp() throws NoSuchMethodException {
        scanner = new Scanner(System.in);
        printStream = mock(PrintStream.class);
        ui = spy(new UI(printStream, scanner));
    }


    @Test
    public void checkThatGetOptionsMenuReturnsPopulatedMenu() throws NoSuchMethodException {
        //when
        TreeMap<String, Method> result = OptionsMenu.getOptionsMenu();
        //then
        assertThat(result.keySet(), hasItem("1 - View Books"));
    }

    @Test
    public void checkThatSystemExitsIfUserChoosesX() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //given a scanner input
        String input = "x";

        //when invokeMethod is called
        boolean result = OptionsMenu.invokeMenuOption(ui, input);

        //check that correct value is returned to stop loop in main
        assertThat(result, is(false));
        verify(ui).displayGoodbyeMessage();
    }

    @Test
    //cannot verify print statements beyond user choice/invoke method call?
    public void checkThatSystemInvokesCorrectMethodBasedOnUserChoice() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //given a scanner input
        String input= "1";

        //when invokeMethod is called
        OptionsMenu.invokeMenuOption(ui,input);

        //Then the output is as expected depending on the method/option chosen by tbe user
        verify(ui).displayBooks();
    }

}

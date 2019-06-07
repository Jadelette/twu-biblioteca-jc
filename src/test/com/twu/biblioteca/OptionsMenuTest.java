package com.twu.biblioteca;


import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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
        PrintStream printStream = mock(PrintStream.class);
        UI ui = new UI(printStream);
        String input = "x";

        //when invokeMethod is called
        boolean result = OptionsMenu.invokeMenuOption(ui, input);

        //check that correct value is returned to stop loop in main
        assertThat(result, is(false));
    }

    @Test
    //cannot verify print statements beyond user choice/invoke method call?
    public void checkThatSystemInvokesCorrectMethodBasedOnUserChoice() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //given a scanner input
        PrintStream printStream = mock(PrintStream.class);
        UI ui = spy(new UI(printStream));
        String input= "1";

        //when invokeMethod is called
        OptionsMenu.invokeMenuOption(ui,input);

        //Then the output is as expected depending on the method/option chosen by tbe user
        verify(ui).displayBooks();
    }

}

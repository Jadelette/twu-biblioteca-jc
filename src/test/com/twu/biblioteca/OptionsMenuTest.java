package com.twu.biblioteca;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.contains;
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

        String input = "x";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Scanner mockScanner = new Scanner(System.in);
        UI ui = new UI(printStream);

        //when invokeMethod is called
        OptionsMenu.invokeMenuOption(ui, mockScanner);

        //Then the output is as expected depending on the method/option chosen by tbe user
        verify(printStream).println("Thank you for using Biblioteca! We look forward to seeing you again!");
    }

    @Test
    public void checkThatSystemInvokesCorrectMethodBasedOnUserChoice() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //given a scanner input
        PrintStream printStream = mock(PrintStream.class);

        String inputs = "1 x";
        InputStream inputStream1 = new ByteArrayInputStream(inputs.getBytes());


        System.setIn(inputStream1);
        Scanner mockScanner = new Scanner(System.in);
        UI ui = new UI(printStream);


        String bookTitle = "Catch 22";
        String bookAuthor = "Joseph Heller";
        int bookYear = 1961;

        //when invokeMethod is called
        OptionsMenu.invokeMenuOption(ui, mockScanner);


        //Then the output is as expected depending on the method/option chosen by tbe user
        verify(printStream).printf("%-40.40s %-30.30s  %-30.30s%n", bookTitle, bookAuthor, bookYear);
    }

}

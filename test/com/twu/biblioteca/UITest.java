package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;


import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import static org.mockito.Mockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


import static org.junit.Assert.assertEquals;


public class UITest {

    private PrintStream printStream;
    private UI ui;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        ui = new UI();
    }

    @Test
    public void welcomeMessageReturnsCorrectString() {
        //when
        ui.displayWelcome(printStream);
        //then
        verify(printStream).println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

}

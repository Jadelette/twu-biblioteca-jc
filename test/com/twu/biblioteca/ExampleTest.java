package com.twu.biblioteca;

import static org.mockito.Mockito.*;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;


public class ExampleTest {

    @Test
    public void test() {
        assertEquals(1, 1);
    }

    PrintStream printStream = mock(PrintStream.class);
}

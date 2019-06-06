package com.twu.biblioteca;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.contains;


public class OptionsMenuTest {

    @Test
    public void checkThatGetOptionsMenuReturnsPopulatedMenu() throws NoSuchMethodException {
        //when
        Map<String, Method> result = OptionsMenu.getOptionsMenu();
        //then
        assertThat(result.keySet(), hasItem("1 - View Books"));
    }

}

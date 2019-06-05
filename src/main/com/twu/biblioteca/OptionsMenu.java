package com.twu.biblioteca;

import java.lang.reflect.Method;
import java.util.TreeMap;

public class OptionsMenu {

    private static TreeMap<String, Method> optionsMenu = new TreeMap<String, Method>();

    public static void populateOptions() throws NoSuchMethodException {
        optionsMenu.put("1 - View Books", UI.class.getMethod("displayBooks"));
    }

    public static TreeMap<String, Method> getOptionsMenu() throws NoSuchMethodException {
        populateOptions();
        return optionsMenu;
    }
}

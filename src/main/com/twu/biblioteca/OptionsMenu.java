package com.twu.biblioteca;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class OptionsMenu {

    private static TreeMap<String, Method> optionsMenu = new TreeMap<String, Method>();


    public static void populateOptions() throws NoSuchMethodException {
        optionsMenu.put("1 - View Books", UI.class.getMethod("displayBooks"));
        //add additional menu options here
    }

    public static TreeMap<String, Method> getOptionsMenu() throws NoSuchMethodException {
        populateOptions();
        return optionsMenu;
    }

    public static void invokeMenuOption(UI ui, Scanner scanner) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        String input;
        Boolean proceed = true;

        while (proceed==true) {
            input = ui.getUserInput(scanner);
            if (input.equals("x")) {
                proceed = false;
            } else {
                for (Map.Entry<String, Method> entry : optionsMenu.entrySet()) {
                    if (entry.getKey().contains(input)) {
                        String cmd = entry.getKey();
                        optionsMenu.get(cmd).invoke(ui, null);
                    }
                }
                System.out.println("\nPlease select what you would like to do next");
            }
        }
    }

}

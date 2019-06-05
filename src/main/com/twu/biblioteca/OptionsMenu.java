package com.twu.biblioteca;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Scanner;
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

    public static void invokeMenuOption(UI ui, Scanner scanner) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        String input = ui.askForUserChoice(scanner);
        for (Map.Entry<String, Method> entry : optionsMenu.entrySet()){
            if (entry.getKey().contains(input)){
                String cmd = entry.getKey();
                switch (input){
                    case"1": optionsMenu.get(cmd).invoke(ui, null);
                        break;
                }
            }
        }


    }

}

package com.twu.biblioteca;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class OptionsMenu {

    private static TreeMap<String, Method> optionsMenu = new TreeMap<String, Method>();


    private static void populateOptions() throws NoSuchMethodException {
        optionsMenu.put("1 - View Books", UI.class.getMethod("displayBooks"));
        optionsMenu.put("2 - Reserve Book", UI.class.getMethod("reserveBook"));
        //add additional menu options here
    }

    static TreeMap<String, Method> getOptionsMenu() throws NoSuchMethodException {
        populateOptions();
        return optionsMenu;
    }

    private static ArrayList<String> generateListOfMenuNumbers() {
        Set<String> options = optionsMenu.keySet();
        ArrayList<String> optionNumbers = new ArrayList<>();
        for (String option : options) {
            char temp = option.charAt(0);
            optionNumbers.add(Character.toString(temp));
        }
        return optionNumbers;
    }

    static boolean invokeMenuOption(UI ui, String input) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        ArrayList<String> optionNumbers = generateListOfMenuNumbers();
        boolean proceed = true;
            if (input.equals("x")) {
                ui.displayGoodbyeMessage();
                proceed = false;
            } else if (optionNumbers.contains(input)) {
                for (Map.Entry<String, Method> entry : optionsMenu.entrySet()) {
                    if (entry.getKey().contains(input)) {
                        String cmd = entry.getKey();
                        optionsMenu.get(cmd).invoke(ui, null);
                    }
                }
                System.out.println("\nPlease select what you would like to do next");
            } else {
                System.out.println("Please select a valid option and try again:");
            }

        return proceed;
    }

}

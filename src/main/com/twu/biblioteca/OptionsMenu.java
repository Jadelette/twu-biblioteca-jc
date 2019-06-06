package com.twu.biblioteca;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class OptionsMenu {

    private static Map<String, Method> optionsMenu = new LinkedHashMap<>();
    //TODO It is best practice to define the interface for collections like Maps
    //TODO I have also change to a LinkedHashMap which is preserves the insertion
    //      order of items for when you do get multiple items in your menu


    private static void populateOptions() throws NoSuchMethodException {
        optionsMenu.put("1 - View Books", UI.class.getMethod("displayBooks"));
    }

    static Map<String, Method> getOptionsMenu() throws NoSuchMethodException {
        populateOptions();
        return optionsMenu;
    }

    //TODO This is one way that this could be made simpler. Also lets discuss use of `reflection` at some stage
    //TODO to make this easier to test you may want this method to just ask and respond once and move the loop out into the main method
    static void invokeMenuOption(UI ui, Scanner scanner) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        while(true) {
            String input = ui.askForUserChoice(scanner);

            if("q".equalsIgnoreCase(input)){
                return;
            }

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

package com.twu.biblioteca;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class BibliotecaApp {

    public static void main(String[] args) throws NoSuchMethodException {


        UI ui = new UI(System.out);


        ui.displayWelcome();
        ui.displayOptions();


  /*
        int input = 1;
        String stringifiedInput = Integer.toString(input);
        for (Map.Entry<String, Method> entry : optionsMenu.entrySet()){
            if (entry.getKey().contains(stringifiedInput)){
                String cmd = entry.getKey();
            switch (input){
                case 1: optionsMenu.get(cmd).invoke(ui, books);
                break;
                case 2: optionsMenu.get(cmd).invoke(ui, null);
                break;
                }
            }
        }
*/

    }
}

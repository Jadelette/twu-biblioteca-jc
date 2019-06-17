package com.twu.biblioteca;

import java.util.*;

class OptionsMenu {

    private  TreeMap<String, MenuOption> options;
    private  Scanner scanner;


    public OptionsMenu(TreeMap<String, MenuOption> menu, Scanner scanner) {
        this.scanner = scanner;
        this.options = menu;
    }


    public TreeMap<String, MenuOption> getOptions() {
        return options;
    }

    public ArrayList<String> generateListOfMenuNumbers() {
        Set<String> options = this.options.keySet();
        ArrayList<String> optionNumbers = new ArrayList<>();
        for (String option : options) {
            char temp = option.charAt(0);
            optionNumbers.add(Character.toString(temp));
        }

        return optionNumbers;
    }

    boolean invokeMenuOption(UI ui, String input) {
       ArrayList<String> optionNumbers = this.generateListOfMenuNumbers();
        boolean proceed = true;
            if (input.equals("x")) {
                AppCloser exit = new AppCloser(ui);
                exit.execute();
                proceed = false;
            } else if (optionNumbers.contains(input)) {
                for (Map.Entry<String, MenuOption> entry : options.entrySet()) {
                    if (entry.getKey().contains(input)) {
                        String cmd = entry.getKey();
                        MenuOption option = options.get(cmd);
                        option.execute();
                    }
                }
                System.out.println("\nPlease select what you would like to do next");
            } else {
                System.out.println("Please select a valid option and try again:");
            }

        return proceed;
    }

}

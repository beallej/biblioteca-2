package com.thoughtworks.tw101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tafarii on 9/28/16.
 */
public class Menu {
    private PrintStream printStream;
    private Biblioteca biblioteca;
    private InputReader inputReader;
    private Map<String, MenuItemInterface> menuMap;

    public Menu(PrintStream printStream, Biblioteca biblioteca, InputReader inputReader) {
        this.printStream = printStream;
        this.biblioteca = biblioteca;
        this.inputReader = inputReader;
        this.menuMap = new HashMap<>();
        this.menuMap.put("1", new ListBooksMenuItem(biblioteca));
        this.menuMap.put("2", new CheckoutBookMenuItem(biblioteca));
        this.menuMap.put("3", new ReturnBookMenuItem(biblioteca));
    }

    public void display() {
        printStream.println("1: List Books");
        printStream.println("2: Checkout Book");
        printStream.println("3: Return Book");
        printStream.println("q: Quit");
        printStream.println("Please select an option");
        String choice = inputReader.getString();


        while (!choice.equals("q")) {
            processInput(choice);
            choice = inputReader.getString();
        }

    }

    private void processInput(String input){
        if (menuMap.containsKey(input)) {
            MenuItemInterface menuItem = menuMap.get(input);
            menuItem.run();
        }
        else {
            printStream.println("Select a valid option!");
        }
    }

}

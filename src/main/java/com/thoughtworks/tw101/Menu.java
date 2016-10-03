package com.thoughtworks.tw101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by tafarii on 9/28/16.
 */
public class Menu {
    private PrintStream printStream;
    private Biblioteca biblioteca;
    private InputReader inputReader;

    public Menu(PrintStream printStream, Biblioteca biblioteca, InputReader inputReader) {
        this.printStream = printStream;
        this.biblioteca = biblioteca;
        this.inputReader = inputReader;
    }

    public void display() {
        printStream.println("1: List Books");
        printStream.println("2: Checkout Book");
        printStream.println("q: Quit");
        printStream.println("Please select an option");
        String choice = inputReader.getString();


        while (choice != "q") {
            choice = processInput(choice);
        }

    }

    private String processInput(String input){
        if(input.equals("1")){
            biblioteca.listBooks();
        }
        else if(input.equals("2")){
            biblioteca.checkoutBook();
        }
        else if(input.equals("q")){
            return "q";
        }
        else {
            printStream.println("Select a valid option!");
        }
        return inputReader.getString();
    }

}

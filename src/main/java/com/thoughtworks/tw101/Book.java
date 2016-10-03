package com.thoughtworks.tw101;

import java.io.PrintStream;


/**
 * Created by tafarii on 9/28/16.
 */
public class Book {

    private PrintStream printStream;
    private String title;
    private String author;
    private String year;

    public Book(PrintStream printStream, String title, String author, String year) {
        this.printStream = printStream;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public void display(){
        printStream.println(title + " | " + author + " | " + year);
    }

    public boolean hasTitle(String title) {
        return this.title.equals(title);
    }
}

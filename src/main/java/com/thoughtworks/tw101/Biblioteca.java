package com.thoughtworks.tw101;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tafarii on 9/27/16.
 */
public class Biblioteca {
    private List<Book> books;
    private PrintStream printStream;
    private InputReader inputReader;

    public Biblioteca(List<Book> books, PrintStream printStream, InputReader inputReader) {
        this.books = books;
        this.printStream = printStream;
        this.inputReader = inputReader;
    }

    public void listBooks() {
        for (Book book : books) {
            book.display();
        }
    }

    public void checkoutBook() {
        printStream.println("Please enter the title of the book.");
        String title = inputReader.getString();

        Iterator<Book> bookIterator = books.iterator();

        while (bookIterator.hasNext()) {
            Book currentBook = bookIterator.next();
            if (currentBook.hasTitle(title)){
                bookIterator.remove();
                printStream.println("Thank you! Enjoy the book");
            }
        }

    }
}

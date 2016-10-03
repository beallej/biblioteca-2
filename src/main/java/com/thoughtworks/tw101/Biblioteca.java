package com.thoughtworks.tw101;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tafarii on 9/27/16.
 */
public class Biblioteca {
    private List<Book> books;
    private List<Book> checkedOutBooks;
    private PrintStream printStream;
    private InputReader inputReader;

    public Biblioteca(List<Book> books, List<Book> checkedOutBooks, PrintStream printStream, InputReader inputReader) {
        this.books = books;
        this.checkedOutBooks = checkedOutBooks;
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
                checkedOutBooks.add(currentBook);
                bookIterator.remove();
                printStream.println("Thank you! Enjoy the book");
                return;
            }
        }
        printStream.println("That book is not available.");
    }

    public void returnBook() {
        printStream.println("Please enter the title of the book to return.");
        String title = inputReader.getString();
        Iterator<Book> bookIterator = checkedOutBooks.iterator();

        while (bookIterator.hasNext()) {
            Book currentBook = bookIterator.next();
            if (currentBook.hasTitle(title)){
                books.add(currentBook);
                bookIterator.remove();
                return;
            }
        }
    }
}

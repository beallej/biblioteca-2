package com.thoughtworks.tw101;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by tafarii on 9/27/16.
 */
public class BibliotecaTest {

    private Biblioteca biblioteca;
    private List<Book> books;
    private PrintStream printStream;
    private InputReader inputReader;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<>();
        printStream = mock(PrintStream.class);
        inputReader = mock(InputReader.class);
        biblioteca = new Biblioteca(books, printStream, inputReader);
    }

    @Test
    public void shouldDisplayOneBookWhenStartingWithOneBook() throws Exception {
        Book book = mock(Book.class);
        books.add(book);
        biblioteca.listBooks();
        verify(book).display();
    }

    @Test
    public void shouldDisplayTwoBooksWhenStartingWithTwoBooks() throws Exception {
        Book book1 = mock(Book.class);
        Book book2 = mock(Book.class);
        books.add(book1);
        books.add(book2);
        biblioteca.listBooks();
        verify(book1).display();
        verify(book2).display();
    }

    @Test
    public void shouldAskUserForBookTitleWhenCheckingOutBook() throws Exception {
        biblioteca.checkoutBook();
        verify(printStream).println("Please enter the title of the book.");
    }

    @Test
    public void shouldCheckoutBookWhenGivenTitle() throws Exception {
        Book book = mock(Book.class);
        books.add(book);
        String title = "Book";
        when(inputReader.getString()).thenReturn(title);
        when(book.hasTitle(title)).thenReturn(true);
        biblioteca.checkoutBook();
        assertFalse(books.contains(book));
    }

    @Test
    public void shouldDisplayMessageWhenCheckingOutSuccesfully() throws Exception {
        Book book = mock(Book.class);
        books.add(book);
        String title = "Book";
        when(inputReader.getString()).thenReturn(title);
        when(book.hasTitle(title)).thenReturn(true);
        biblioteca.checkoutBook();
        verify(printStream).println("Thank you! Enjoy the book");

    }
}
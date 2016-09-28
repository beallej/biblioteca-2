package com.thoughtworks.tw101;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by tafarii on 9/27/16.
 */
public class BibliotecaTest {

    private PrintStream printStream;
    private Biblioteca biblioteca;
    private List<Book> books;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        books = new ArrayList<>();
        biblioteca = new Biblioteca(printStream, books);

    }

    @Test
    public void shouldDisplayWelcomeMessageWhenApplicationStarts() throws Exception {
        biblioteca.start();
        verify(printStream).println("Welcome!");
    }

    @Test
    public void shouldDisplayOneBookAfterWelcomeMessage() throws Exception {
        books.add(new Book(printStream, "Book 1", "Lejia", "2016"));
        biblioteca.start();
        verify(printStream).println("Book 1 | Lejia | 2016");
    }

    @Test
    public void shouldDisplayTwoBooksAfterWelcomeMessage() throws Exception {
        books.add(new Book(printStream, "Book 1", "Lejia", "2016"));
        books.add(new Book(printStream, "Book 2", "Tafarii", "2016"));

        biblioteca.start();
        verify(printStream).println("Book 2 | Tafarii | 2016");
    }

}
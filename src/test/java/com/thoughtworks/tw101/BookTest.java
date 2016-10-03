package com.thoughtworks.tw101;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by tafarii on 9/28/16.
 */
public class BookTest {

    private PrintStream printStream;
    private Book book;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        book = new Book(printStream, "Title", "Author", "Year");
    }

    @Test
    public void shouldDisplayTitleAuthorAndYearWhenCallingDisplay() throws Exception {
        book.display();
        verify(printStream).println("Title | Author | Year");
    }

    @Test
    public void shouldReturnTrueWhenBookTitleMatches() throws Exception {
        assertTrue(book.hasTitle("Title"));
    }

    @Test
    public void shouldReturnFalseWhenBookTitleDoesNotMatch() throws Exception {
        assertFalse(book.hasTitle("Title2"));
    }
}

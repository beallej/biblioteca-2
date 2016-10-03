package com.thoughtworks.tw101;

import com.javafx.tools.doclets.internal.toolkit.util.DocFinder;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.Scanner;

import static org.mockito.Mockito.*;

/**
 * Created by tafarii on 9/28/16.
 */
public class MenuTest {
    PrintStream printStream;
    Menu menu;
    private Biblioteca biblioteca;
    private InputReader inputReader;

    @Before
    public void setUp() throws Exception {
        inputReader = mock(InputReader.class);
        printStream = mock(PrintStream.class);
        biblioteca = mock(Biblioteca.class);
        menu = new Menu(printStream, biblioteca, inputReader);
    }

    @Test
    public void shouldDisplayOptionListBooksWhenMenuIsDisplayed() throws Exception {
        when(inputReader.getString()).thenReturn("1", "q");
        menu.display();
        verify(printStream).println("1: List Books");
    }

    @Test
    public void shouldDisplayOptionCheckoutBookWhenMenuIsDisplayed() throws Exception {
        when(inputReader.getString()).thenReturn("2", "q");
        menu.display();
        verify(printStream).println("2: Checkout Book");
    }

    @Test
    public void shouldPrintPromptWhenMenuIsDisplayed() throws Exception {
        when(inputReader.getString()).thenReturn("1", "q");
        menu.display();
        verify(printStream).println("Please select an option");
    }

    @Test
    public void shouldListBooksWhenUserInputsOne() throws Exception {
        when(inputReader.getString()).thenReturn("1", "q");
        menu.display();
        verify(biblioteca).listBooks();
    }

    @Test
    public void shouldCheckoutBookWhenUserInputsTwo() throws Exception {
        when(inputReader.getString()).thenReturn("2", "q");
        menu.display();
        verify(biblioteca).checkoutBook();
    }

    @Test
    public void shouldDisplayErrorMessageWhenSelectingInvalidOption() throws Exception {
        when(inputReader.getString()).thenReturn("x", "q");
        menu.display();
        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldBeAbleToContinueChoosingOptionsWhenFirstOptionIsInvalid() throws Exception {
        when(inputReader.getString()).thenReturn("x", "1", "q");
        menu.display();
        verify(biblioteca).listBooks();

    }

    @Test
    public void shouldDisplayQuitOptionWhenMenuIsPrinted() throws Exception {
        when(inputReader.getString()).thenReturn("q");
        menu.display();
        verify(printStream).println("q: Quit");
    }

    @Test
    public void shouldQuitWhenUserInputsQ() throws Exception {
        when(inputReader.getString()).thenReturn("q");
        menu.display();
        verify(inputReader, times(1)).getString();

    }

    @Test
    public void shouldDisplayOptionToReturnBookWhenDisplayingMenu() throws Exception {
        when(inputReader.getString()).thenReturn("q");
        menu.display();
        verify(printStream).println("3: Return Book");

    }

    @Test
    public void shouldReturnBookWhenUserInputs3() throws Exception {
        when(inputReader.getString()).thenReturn("3", "q");
        menu.display();
        verify(biblioteca).returnBook();

    }
}

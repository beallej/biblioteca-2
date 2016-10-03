package com.thoughtworks.tw101;

/**
 * Created by jbealle on 10/3/16.
 */
public class ListBooksMenuItem implements MenuItemInterface {
    private Biblioteca biblioteca;

    public ListBooksMenuItem(Biblioteca biblioteca) {

        this.biblioteca = biblioteca;
    }

    @Override
    public void run() {
        biblioteca.listBooks();
    }
}

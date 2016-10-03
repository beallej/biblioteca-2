package com.thoughtworks.tw101;

/**
 * Created by jbealle on 10/3/16.
 */
public class CheckoutBookMenuItem implements MenuItemInterface {
    private Biblioteca biblioteca;

    public CheckoutBookMenuItem(Biblioteca biblioteca) {

        this.biblioteca = biblioteca;
    }

    @Override
    public void run() {
        biblioteca.checkoutBook();
    }
}

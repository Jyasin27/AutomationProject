package application.pages;

import Roman.Roman;
import selenium.AbstractPage;

public class CartPage extends AbstractPage {

    public CartPage(Roman roman)
    {
        super(roman);
    }

    public boolean checkItemInCart()
    {
        navigateTo();


    }

    @Override
    protected String get_uri() {
        return "https://demowebshop.tricentis.com/cart";
    }

    @Override
    public boolean waitForDisplayed() {
        return false;
    }
}

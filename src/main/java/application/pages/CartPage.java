package application.pages;

import Roman.Roman;
import selenium.AbstractPage;

public class CartPage extends AbstractPage {

    public CartPage(Roman roman)
    {
        super(roman);
    }

    @Override
    protected String get_uri() {
        return null;
    }

    @Override
    public boolean waitForDisplayed() {
        return false;
    }
}

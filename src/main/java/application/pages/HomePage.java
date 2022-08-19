package application.pages;

import Roman.Roman;
import org.openqa.selenium.By;
import selenium.AbstractPage;

public class HomePage extends AbstractPage {

    private By registerBtn = By.xpath("//a[text()='Register']");

    public HomePage (Roman roman)
    {
        super(roman);

    }
    public void navigateToRegisteration()
    {
        navigateTo();
        click
    }

    @Override
    protected String get_uri() {
        return "http://demowebshop.tricentis.com/";
    }

    @Override
    public boolean waitForDisplayed() {
        return false;
    }
}

package application.pages;

import Roman.Roman;
import org.openqa.selenium.By;
import selenium.AbstractPage;

public class HomePage extends AbstractPage {

    private By loginBtn = By.xpath("//div[@class='header-links']//li//a[text()='Log in']");

    public HomePage (Roman roman)
    {
        super(roman);

    }
    public void goToLogin()
    {
        navigateTo();
        click(loginBtn);

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

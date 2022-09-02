package application.pages;

import Roman.Roman;
import org.openqa.selenium.By;
import selenium.AbstractPage;

public class HomePage extends AbstractPage {

    private By loginBtn = By.xpath("//a[text()='Log in']");

    public HomePage (Roman roman) //Requesting roman driver
    {
        super(roman);

    }
    public void goToLogin()
    {
        navigateTo();
        click(loginBtn);

    }

    //Required method when extending the abstract class
    @Override
    protected String get_uri() {
        return "http://demowebshop.tricentis.com/";
    }

    @Override
    public boolean waitForDisplayed() {
        return false;
    }
}

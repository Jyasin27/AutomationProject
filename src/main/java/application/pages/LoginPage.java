package application.pages;

import Roman.Roman;
import application.models.Credentials;
import org.openqa.selenium.By;
import selenium.AbstractPage;

public class LoginPage extends AbstractPage {

    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By loginBtn = By.xpath("//div[@class='buttons']//input[@class='button-1 login-button']");

    public LoginPage(Roman roman)
    {
        super(roman);
    }
    public void login(Credentials credentials)
    {
        sendKeys(emailField, credentials.userEmail);
        sendKeys(passwordField, credentials.password);
        click(loginBtn);
    }

    @Override
    protected String get_uri() {
        return "https://demowebshop.tricentis.com/register";
    }

    @Override
    public boolean waitForDisplayed() {
        return false;
    }
}

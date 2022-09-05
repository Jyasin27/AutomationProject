package application.pages;

import Roman.Roman;
import application.models.Credentials;
import org.openqa.selenium.By;
import selenium.AbstractPage;

public class LoginPage extends AbstractPage {

    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By loginBtn = By.xpath("//input[@class='button-1 login-button']");

    public LoginPage(Roman roman)
    {
        super(roman);
    }

    public void login(Credentials credentials) //conduct the login functionality
    {
        sendKeys(emailField, credentials.userEmail); //type the credentials into the email field
        sendKeys(passwordField, credentials.password);
        click(loginBtn);
        stepPassed("Logging in");
    }

    @Override
    protected String get_uri() {
        return "https://demowebshop.tricentis.com/login";
    }

    @Override
    public boolean waitForDisplayed() {
        return false;
    }
}

package application.pages;

import Roman.Roman;
import application.models.Credentials;
import org.openqa.selenium.By;
import selenium.AbstractPage;

public class LoginPage extends AbstractPage {

    private By genderRadioBtn = By.id("gender-female"); //change to get every gender
    private By fNameField = By.id("FirstName");
    private By lNameField = By.id("LastName");
    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By confirmPassField = By.id("ConfirmPassword");
    private By registerBTn = By.id("register-button");
    private By continueBtn = By.xpath("//input[@class ='button-1 register-continue-button']");

    public LoginPage(Roman roman)
    {
        super(roman);
    }
    public void login(Credentials credentials)
    {
        sendKeys(emailField, credentials.userEmail);
        sendKeys(passwordField, credentials.password);
        click(registerBTn);
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

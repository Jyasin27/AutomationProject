package application.pages;

import Roman.Roman;
import application.models.Credentials;
import org.openqa.selenium.By;
import selenium.AbstractPage;

public class RegisterPage extends AbstractPage {

    private By genderRadioBtn = By.id("gender-female"); //change to get every gender
    private By fNameField = By.id("FirstName");
    private By lNameField = By.id("LastName");
    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By confirmPassField = By.id("ConfirmPassword");
    private By registerBTn = By.id("register-button");
    private By continueBtn = By.xpath("//input[@class ='button-1 register-continue-button']");

    public RegisterPage(Roman roman)
    {
        super(roman);
    }
    public void register(Credentials credentials)
    {
        click(genderRadioBtn);
        sendKeys(fNameField, credentials.firstName);
        sendKeys(lNameField, credentials.lastName);
        sendKeys(emailField, credentials.userEmail);
        sendKeys(passwordField, credentials.password);
        sendKeys(confirmPassField, credentials.confirmPassword);
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

package application;

import Roman.Roman;
import application.pages.HomePage;
import application.pages.LoginPage;

public class TricentisApplication {

    public HomePage homePage;
    public LoginPage loginPage;
    public StorePage storePage;
    public CartPage cartPage;

    public TricentisApplication(Roman roman)
    {
        homePage = new HomePage(roman);
        loginPage = new LoginPage(roman);
        storePage = new StorePage(roman);
        cartPage = new CartPage(roman);
    }
}

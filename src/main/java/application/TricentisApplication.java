package application;

import Roman.Roman;
import application.pages.CartPage;
import application.pages.HomePage;
import application.pages.LoginPage;
import application.pages.StorePage;

public class TricentisApplication {

    public HomePage homePage;
    public LoginPage loginPage;
    public StorePage storePage;
    public CartPage cartPage;

    public TricentisApplication(Roman roman, String tabName, String catName, String itemName)
    {
        homePage = new HomePage(roman);
        loginPage = new LoginPage(roman);
        storePage = new StorePage(roman, tabName,catName, itemName);
        cartPage = new CartPage(roman, itemName);
    }
}

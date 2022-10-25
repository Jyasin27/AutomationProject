package application;

import Roman.Roman;
import application.pages.CartPage;
import application.pages.HomePage;
import application.pages.LoginPage;
import application.pages.StorePage;

public class TricentisApplication {

    //public fields
    public HomePage homePage;
    public LoginPage loginPage;
    public StorePage storePage;
    public CartPage cartPage;

    public TricentisApplication(Roman roman, String tabName, String catName, String itemName)
    {
        homePage = new HomePage(roman); //objects
        loginPage = new LoginPage(roman);
        storePage = new StorePage(roman, tabName,catName, itemName);
        cartPage = new CartPage(roman, itemName);
    }
    public TricentisApplication(Roman roman, String tabName,String itemName)
    {
        homePage = new HomePage(roman); //objects
        loginPage = new LoginPage(roman);
        storePage = new StorePage(roman, tabName,itemName);
        cartPage = new CartPage(roman, itemName);
    }
}

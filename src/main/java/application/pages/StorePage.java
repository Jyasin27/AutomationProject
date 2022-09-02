package application.pages;

import Roman.Roman;
import application.widget.CategoryBox;
import application.widget.Item;
import application.widget.Tabs;
import org.openqa.selenium.By;
import selenium.AbstractPage;

public class StorePage extends AbstractPage {

    private CategoryBox categoryBox;
    private Item item;
    private Tabs tab;
    private By cartBtn = By.xpath("//li[@id='topcartlink']//span[text()='Shopping cart']");


    public StorePage(Roman roman, String tabName,String catName,String itemName )
    {
        super(roman);
        this.tab = new Tabs(roman, tabName);                //Instantiating tab as a new tabs object
        this.categoryBox = new CategoryBox(roman,catName); //view of category in the tab selected tab
        this.item = new Item(roman,itemName);

    }
    public void selectTab()
    {
       tab.clickTab();
    }
    public void selectCategoryBox()
    {
        categoryBox.clickCategory();
    }
    public void addToCart()
    {
        item.clickAddToCartBtn();
        _driver.navigate().refresh(); //refreshes page after item has been added
    }
    public void goToCartPage()
    {
        click(cartBtn);
    }



    @Override
    protected String get_uri() {
        return "https://demowebshop.tricentis.com/computers";
    }

    @Override
    public boolean waitForDisplayed() {
        return false;
    }
}

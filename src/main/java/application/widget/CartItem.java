package application.widget;

import Roman.Roman;
import org.openqa.selenium.By;
import selenium.AbstractWidget;


public class CartItem extends AbstractWidget {

    private String itemName;
    private By item = By.xpath(".");
    private By checkBox = By.xpath(".//input[@type='checkbox']");
    public CartItem(Roman roman, String itemName)
    {
        super(roman);
        this.itemName = itemName;

    }
    public By getItem()
    {
        return item;
    }
    public String getItemText()
    {
        return getText(item);

    }
    public void selectCheckbox()
    {
        click(checkBox);
    }



    @Override
    protected By _Locator()
    {
        return By.xpath("//a[text() ='"+itemName+"']/ancestor::tr[@class='cart-item-row']");
    }


    public boolean waitForDisplayed() {
        return false;
    }


}

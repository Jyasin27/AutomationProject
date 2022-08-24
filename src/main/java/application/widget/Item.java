package application.widget;

import Roman.Roman;
import org.openqa.selenium.By;
import selenium.AbstractWidget;

public class Item extends AbstractWidget {

    private String itemName;                        //Name of item in tab
    private By addToCartBtn =By.xpath(".//input");

    public Item(Roman roman, String itemName)
    {
        super(roman);
        this.itemName = itemName;
    }

    public void clickAddToCartBtn()
    {
        click(addToCartBtn);
    }

    @Override
    protected By _Locator() {
        return By.xpath("//a[text()='"+itemName+"']/ancestor::div[@class='item-box']");
    }

    @Override
    public boolean waitForDisplayed() {
        return false;
    }
}

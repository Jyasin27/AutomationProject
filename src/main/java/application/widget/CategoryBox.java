package application.widget;

import Roman.Roman;
import org.openqa.selenium.By;
import selenium.AbstractWidget;

public class CategoryBox extends AbstractWidget {

    private String catName;
    private By item = By.xpath("."); //what follows the dot, adds to the base locator

    public CategoryBox(Roman roman, String catName)
    {
        super(roman);
        this.catName =catName;
    }

    public void clickCategory()
    {
        click(item);
    }
    @Override //base of locator to find
    protected By _Locator() {
        return By.xpath("//a[contains(text(),'"+ catName +"')]/ancestor::div[@class='item-box']");
    }

    @Override
    public boolean waitForDisplayed() {
        return false;
    }
}

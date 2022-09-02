package application.widget;

import Roman.Roman;
import org.openqa.selenium.By;
import selenium.AbstractWidget;

public class CategoryBox extends AbstractWidget {


    private String catName;
    private By item = By.xpath(".");

    public CategoryBox(Roman roman, String catName)
    {
        super(roman);
        this.catName = catName;
    }

    public void clickCategory()
    {
        click(item);
    }

    @Override //base of locator to find
    protected By _Locator() {
        return By.xpath("//a[contains(text(),'"+ catName +"')]/ancestor::div[@class='item-box']"); //Locates the sub-category box
    }

    @Override
    public boolean waitForDisplayed() {
        return false;
    }
}

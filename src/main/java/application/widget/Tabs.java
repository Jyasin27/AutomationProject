package application.widget;

import Roman.Roman;
import org.openqa.selenium.By;
import selenium.AbstractWidget;

public class Tabs extends AbstractWidget {

    private String tabName;
    private By tab = By.xpath(".");

    public Tabs(Roman roman, String tabName)
    {
        super(roman);
        this.tabName = tabName;
    }


    public void clickTab()
    {
        click(tab);
    }

    @Override
    protected By _Locator() {
        return By.xpath("//a[contains(text(), 'Books')]/ancestor::div[@class='listbox']//a[contains(text(), '"+tabName+"')]");
    }

    @Override
    public boolean waitForDisplayed() {
        return false;
    }
}

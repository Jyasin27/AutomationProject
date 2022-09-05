package application.pages;

import Roman.Roman;
import application.widget.CartItem;
import org.openqa.selenium.By;
import selenium.AbstractPage;

public class CartPage extends AbstractPage {

    private By emptyTextMsg = By.xpath("//div[@class='order-summary-content']");
    private By updateCartBtn = By.xpath("//input[@name='updatecart']");
    private CartItem cartItem;

    public CartPage(Roman roman, String itemName)
    {
        super(roman);
        this.cartItem = new CartItem(roman, itemName);//Instantiate widgets in constructor

    }

    public String checkItemName()
    {
       return cartItem.getItemText();
    }

    public void removeCartItem()
    {
        cartItem.selectCheckbox();
        click(updateCartBtn);
        System.out.println("Item has been removed");
    }

    public boolean checkItemIsNotPresent()
    {
        if(validateElement_Displayed(emptyTextMsg) || find(cartItem.getItem()).size() == 0) //returns a list of every cart item with that name
        {
            return true;
        }
        return false;
    }

    @Override
    protected String get_uri() {
        return "https://demowebshop.tricentis.com/cart";
    }

    @Override
    public boolean waitForDisplayed() {
        return false;
    }
}

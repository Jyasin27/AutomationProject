package unittests;

import Roman.RomanBase;
import application.TricentisApplication;
import application.models.Credentials;
import listeners.Listener;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(Listener.class)
public class TricentisTests1 extends RomanBase {
    @Before
    public void setUP()
    {
        roman()._driver = roman().selenium.getChromeDriver();
        roman()._driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void tricentisTest()
    {
        String itemName = "14.1-inch Laptop";
        TricentisApplication app = new TricentisApplication(roman(), "Computers", "Notebooks", itemName);
        app.homePage.goToLogin();
        app.loginPage.login(new Credentials("ttesting@gmail.com","TTestingPassword"));
        app.storePage.selectTab();
        app.storePage.selectCategoryBox();
        app.storePage.addToCart();
        app.storePage.goToCartPage();

        assertTrue(app.cartPage.checkItemName().contains(itemName)); //check if the actual contains the name of the item

        app.cartPage.removeCartItem();

        assertTrue(app.cartPage.checkItemIsNotPresent());
        System.out.println("Class1 Tricentis 1");

    }


}



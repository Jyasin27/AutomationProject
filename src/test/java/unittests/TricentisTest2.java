package unittests;
import Roman.RomanBase;
import application.TricentisApplication;
import application.models.Credentials;
import listeners.Listener;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(Listener.class)
public class TricentisTest2 extends RomanBase {

    @Before
    public void setUP()
    {
        roman()._driver = roman().selenium.getChromeDriver();
        roman()._driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void tricentisTest2()
    {
        String itemName = "Computing and Internet";
        TricentisApplication app = new TricentisApplication(roman(), "Books", itemName);
        app.homePage.goToLogin();
        app.loginPage.login(new Credentials("ttesting@gmail.com","TTestingPassword"));
        app.storePage.selectTab();
        app.storePage.addToCart();
        app.storePage.goToCartPage();

        assertTrue(app.cartPage.checkItemName().contains(itemName)); //check if the actual contains the name of the item

        app.cartPage.removeCartItem();

        assertTrue(app.cartPage.checkItemIsNotPresent());
        System.out.println("Class2 Tricentis 2");

    }

}

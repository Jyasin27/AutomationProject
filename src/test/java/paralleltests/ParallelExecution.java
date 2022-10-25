package paralleltests;

import Roman.RomanBase;
import application.TricentisApplication;
import application.models.Credentials;
import listeners.Listener;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * ParallelExecution is set up and configured by Junit.
 * You must have at least Junit 5.3 added to your project for this to work.
 * We need to create a junit-platform.properties file in the Resources Folder to enable Parallel Execution.
 * Example: https://www.swtestacademy.com/junit5-parallel-test-execution/
 */
@ExtendWith(Listener.class)
@Execution(ExecutionMode.CONCURRENT)
public class ParallelExecution extends RomanBase {
    /**
     * The @BeforeAll here to set up the report.
     * For parallel execution it also sets a default test name.
     * We should NOT use the superclass BeforeEvery method for Parallel Execution.
     * It will likely cause report inconsistencies like extra tests being created blank.     *
     */
    @BeforeEach
    public void setUP()
    {
        roman()._driver = roman().selenium.getChromeDriver();
        roman()._driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    /**
     * There is no @Order tag as parallel tests will run at the same time.
     * Each @Test must have it's own dependencies and will require some checking if the reporting is done correctly.
     */
    @Test
    public void tricentisTest1()
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
    @Test
    public void tricentisTest2()
    {
        String itemName = "Computing and Internet";
        TricentisApplication app = new TricentisApplication(roman(), "TV", itemName);
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
    @AfterEach
    public void teardown()
    {
        roman()._driver.quit();
    }

}

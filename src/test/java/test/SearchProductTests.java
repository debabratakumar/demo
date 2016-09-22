package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;

//import static utility.DriverManagerUtility.driverManager.getDriver;
import static java.lang.Thread.*;
import static utility.DriverManagerUtility.closeDriver;
import static utility.DriverManagerUtility.getDriver;

//import static utility.DriverManagerUtility.getDriver;

/**
 * Created by debabk on 05/09/16.
 */

@Listeners(utility.ReportListener.class)
public class SearchProductTests extends BaseTest {

    @BeforeTest
    public void setUp(){

        System.out.println(" Test 1");
    }

    @Test
    public void searchSpecificProduct() throws InterruptedException {


        HomePage homePage=setBrowserType("chrome").setPlatform("MAC").build().launchAppWithoutLogin();

        homePage.setSearchTextBox("Nikon").clickSearchButton();

        closeDriver();

        sleep(2000);
    }

    @Test
    public void searchSpecificProduct2(){


        HomePage homePage=setBrowserType("chrome").setPlatform("MAC").build().launchAppWithoutLogin();

        homePage.setSearchTextBox("Debabrata").clickSearchButton();

        closeDriver();

    }

    @AfterTest
    public void tearDown(){
      // driver.quit();
       // endTest();
    }
}

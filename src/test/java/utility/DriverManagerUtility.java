package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

/**
 * Created by debabk on 07/09/16.
 */
public final class DriverManagerUtility {

    private static  WebDriver driver=null;

    private final static DesiredCapabilities driverCapabilities=new DesiredCapabilities();

    /*private DriverManagerUtility(){

    }*/


    public static WebDriver getDriver(){
        if(driver==null) {
            switch (driverCapabilities.getBrowserName()) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "/Users/debabk/Desktop/Softwares/mobile automation/chromedriver");
                    driver = new ChromeDriver();
                    driver.get("http://demo.nopcommerce.com/");
                    break;
                default:
                    System.setProperty("webdriver.chrome.driver", "/Users/debabk/Desktop/Softwares/mobile automation/chromedriver");
                    driver = new ChromeDriver();
                    driver.get("http://demo.nopcommerce.com/");
                    break;

            }
        }

        return driver;
    }

    public static DesiredCapabilities setDesiredCapability(Map<String,String> environmentMap){
        driverCapabilities.setCapability("browserName",environmentMap.get("browserName"));

        if(environmentMap.containsKey("platform"))
          driverCapabilities.setCapability("platform",environmentMap.get("platform"));

        return driverCapabilities;
    }

    public  static void closeDriver(){
        driver.quit();
        driver=null;
    }



}

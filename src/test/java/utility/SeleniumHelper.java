package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import static utility.DriverManagerUtility.getDriver;

/**
 * Created by debabk on 09/09/16.
 */
public class SeleniumHelper {

    private  static WebDriver driver;

    private static final Logger logger=Logger.getLogger(SeleniumHelper.class.getName());

    static{
        logger.addHandler(new ConsoleHandler());
    }


    private static WebElement findElement(By elementLocator ) throws NoSuchElementException {

        WebElement element=driver.findElement(elementLocator);
        logger.log(Level.INFO," Identified Element: "+element.getTagName()+" ::: id : "+element.getAttribute("id"));

        return element;

    }

    private List<WebElement> findElements(By elementLocator ) throws NoSuchElementException{
        List<WebElement> element=null;
        try{
            element=driver.findElements(elementLocator);
            logger.log(Level.INFO," Identified Element: ",element.get(0).getTagName());
        }
        catch (NoSuchElementException e){
            logger.log(Level.SEVERE,"MSG: Element does not exist : Error: "+e);
        }

        return element;

    }

    protected void setTextValue(By elementLocator, String text) throws NoSuchElementException{

        findElement(elementLocator).clear();
        findElement(elementLocator).sendKeys(text);
        logger.log(Level.INFO, " Succefully Set text value :  " + text);

    }

    protected void click(By elementLocator) throws NoSuchElementException{

        findElement(elementLocator).click();
        logger.log(Level.INFO,"Successfully clicked element : "+elementLocator);

    }
}

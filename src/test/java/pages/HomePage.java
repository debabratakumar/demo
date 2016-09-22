package pages;

import org.openqa.selenium.By;

/**
 * Created by debabk on 02/09/16.
 */
public class HomePage extends BasePage {

    By txtBoxSearch=By.cssSelector("input[id='small-searchterms']");
    By btnSearch=By.cssSelector("input[type='submit'][value='Search']");

    public HomePage(){
       // driver.get("http://demo.nopcommerce.com/");
    }

    public HomePage setSearchTextBox(String text){
        setTextValue(txtBoxSearch,text);
        return this;
    }

    public HomePage clickSearchButton(){
        click(btnSearch);
        return this;

    }

}

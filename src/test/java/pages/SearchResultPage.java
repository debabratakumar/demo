package pages;

import org.openqa.selenium.By;

/**
 * Created by debabk on 06/09/16.
 */
public class SearchResultPage extends BasePage {

    private final By searchTxtBox=By.cssSelector("input[class='search-text valid'][id='q']");
    private final By advanceSearchChkBox=By.cssSelector("input[id='adv']");

    private final By searchBtn=By.cssSelector("input[class='button-1 search-button']");


}

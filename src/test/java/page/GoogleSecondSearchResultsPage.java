package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSecondSearchResultsPage extends GoogleBasePage {

    @FindBy(id = "lst-ib")
    private WebElement searchField;

    /**
     * Constructor of Second Search Results Page
     * @param webDriver - webDriver instance
     */
    public GoogleSecondSearchResultsPage(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method for checking Second Search Results Page loading conditions
     */
    public boolean isPageLoaded() {
        waitUntilElementIsVisible(searchField, 10);

        return searchField.isDisplayed();
    }
}

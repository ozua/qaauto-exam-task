package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleFirstSearchResultsPage extends GoogleBasePage {

    @FindBy(id = "lst-ib")
    private WebElement searchField;

    @FindBy(xpath = "//a[@aria-label='Page 2']")
    private WebElement secondPage;

    /**
     * Constructor of First Search Results Page
     * @param webDriver - webDriver instance
     */
    public GoogleFirstSearchResultsPage(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method for checking First Search Results Page loading conditions
     */
    public boolean isPageLoaded() {
        waitUntilElementIsVisible(searchField, 15);

        return searchField.isDisplayed();
    }

    /**
     * Method for navigating to Second Search Results Page
     * @return - returns Second Search Results Page
     */
    public GoogleSecondSearchResultsPage clickOnSecondPage() {
        secondPage.click();

        return new GoogleSecondSearchResultsPage(webDriver);
    }
}

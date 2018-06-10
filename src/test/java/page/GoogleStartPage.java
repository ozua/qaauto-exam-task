package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleStartPage extends GoogleBasePage {

    @FindBy(id = "lst-ib")
    private WebElement searchField;

    @FindBy(xpath = "//input[@class='lsb' and contains(@value, 'Google')]")
    private WebElement searchButton;

    /**
     * Constructor of Start Page
     * @param webDriver - webDriver instance
     */
    public GoogleStartPage(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        waitUntilElementIsVisible(searchField, 10);
    }

    /**
     * Method for searching terms on Start Page
     * @param searchTerm - term that you need to find with help of Start Page
     * @return - returns results of searching in to new First Search Results Page
     */
    public GoogleFirstSearchResultsPage search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        waitUntilElementIsClickable(searchButton, 10);
        searchButton.click();

        waitUntilElementIsVisible(searchField, 10);

        return new GoogleFirstSearchResultsPage(webDriver);
    }

    /**
     * Method for checking Start Page loading conditions
     */
    public boolean isPageLoaded() {
        waitUntilElementIsVisible(searchField, 10);

        return searchField.isDisplayed();
    }

}

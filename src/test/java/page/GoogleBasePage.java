package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * General class of ExamTask project
 */
public abstract class GoogleBasePage {
    protected WebDriver webDriver;

    /**
     * Constructor of BasePage
     * @param webDriver - webDriver instance
     */
    public GoogleBasePage (WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//div[@class='srg']/div[@class='g']")
    private List<WebElement> searchResultElements;

    /**
     * Method for checking page loading conditions
     */
    abstract boolean isPageLoaded();

    /**
     * Method for stopping test until all matched elements will be available to click on page
     * @param webElement - webElement instance
     * @param timeOutInSeconds - wait time until all matched conditions will be passed
     * @return - returns waited webElement
     */
    public WebElement waitUntilElementIsClickable (WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));

        return webElement;
    }

    /**
     * Method for stopping test until all matched elements will be visible on page
     * @param webElement - webElement instance
     * @param timeOutInSeconds - wait time until all matched conditions will be passed
     * @return - returns waited webElement
     */
    public WebElement waitUntilElementIsVisible (WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));

        return webElement;
    }

    /**
     * Method for getting text from search results
     * @return - returns full list of search results
     */
    public List<String> getSearchResults() {
        List<String> searchResultsList = new ArrayList();
        for (WebElement searchResultElement : searchResultElements) {
            ((JavascriptExecutor)webDriver)
                    .executeScript("arguments[0].scrollIntoView();", searchResultElement);
            String searchResultText = searchResultElement.getText();
            searchResultsList.add(searchResultText);
        }
        System.out.println(searchResultsList.size());

        return searchResultsList;
    }
}

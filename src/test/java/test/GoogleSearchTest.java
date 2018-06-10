package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.GoogleFirstSearchResultsPage;
import page.GoogleSecondSearchResultsPage;

import java.util.List;

public class GoogleSearchTest extends GoogleBaseTest{

    @Test
    public void basicSearchTest() {
        String searchTerm = "Selenium";

        GoogleFirstSearchResultsPage googleFirstSearchResultsPage = googleStartPage.search(searchTerm);
        Assert.assertTrue(googleFirstSearchResultsPage.isPageLoaded(), "Google first search results page is not loaded");

        List<String> searchResultsOnFirstPageList = googleFirstSearchResultsPage.getSearchResults();
        Assert.assertEquals(searchResultsOnFirstPageList.size(), 10, "Count of search results on Google first search results page is wrong");

        for (String searchResult : searchResultsOnFirstPageList) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),"Searchterm "+searchTerm+" was not found in: \n"+searchResult);
        }

        GoogleSecondSearchResultsPage googleSecondSearchResultsPage = googleFirstSearchResultsPage.clickOnSecondPage();
        Assert.assertTrue(googleSecondSearchResultsPage.isPageLoaded(), "Google second search results page is not loaded");

        List<String> searchResultsOnSecondPageList = googleFirstSearchResultsPage.getSearchResults();
        Assert.assertEquals(searchResultsOnSecondPageList.size(), 10, "Count of search results on Google second search results page is wrong");

        for (String searchResult : searchResultsOnSecondPageList) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),"Searchterm "+searchTerm+" was not found in: \n"+searchResult);
        }
    }
}

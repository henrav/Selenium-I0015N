package com.example.searchfunctionality;

import com.example.Config;
import com.example.Pages.SearchResultPage;
import com.example.userfunctionality.FacebookLoginLogout;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Objects;

public class SearchFunctionality {
    private final WebDriver driver;
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final FacebookLoginLogout facebookLoginLogout;
    private final SearchResultPage searchResultPage;
    private final WebDriverWait wait;

    public SearchFunctionality(WebDriver driver) {
        this.driver = driver;
        this.facebookLoginLogout = new FacebookLoginLogout(driver);
        this.searchResultPage = new SearchResultPage(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void searchFunctionality() {
        try {//try facebook loginFunctionality
            facebookLoginLogout.loginFunctionality();
            //finding searchbar and sending the searchtext
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(searchResultPage.getSearchBarPath())));
            searchResultPage.clickSearchBar(Config.getSearch("searchtext"));
            //looks for the search text on the page
            Thread.sleep(3000);//waits 3 seconds for the page to load
            //can implement "istextvisible" in SearchResultPage because it just the area where the text is
            //that would make the code look cleaner
            WebElement istextvisible = driver.findElement(By.xpath("//div[@class='x9f619 x1n2onr6 x1ja2u2z xdt5ytf x193iq5w xeuugli x1r8uery x1iyjqo2 xs83m0k x78zum5 x1t2pt76']"));
            if (istextvisible.getText().contains(Objects.requireNonNull(Config.getSearch("searchtext")))) {
                logger.info("Search text found");
            } else {
                logger.info("Search text not found");
            }
        } catch (NoSuchElementException | InterruptedException e) {
            logger.error("Element not found", e);
            throw new RuntimeException(e);
        }
    }
}
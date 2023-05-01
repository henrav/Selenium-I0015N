package com.example.Pages;

import com.example.Config;
import com.example.userfunctionality.FacebookLoginLogout;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.example.driver.Driver.logger;

public class SearchResultPage {
    private WebDriver driver;
    private final String searchBarXpath = "/html/body/div[1]/div/div[1]/div/div[2]/div[3]/div/div/div[1]/div/div/label/input";
        @FindBy(xpath = searchBarXpath)
        private WebElement searchBar;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getSearchBarPath(){
        return searchBarXpath;
    }


    //when "clickSearchBar" and "getSearchBarPath" is used the test is actually in the "welcome page" and not the search result page,
    //but it's still in this class because I don't really know, thought about it now when
    //I was writing this comment


    public void clickSearchBar(String text) {
        searchBar.sendKeys(text);
        searchBar.sendKeys("\n");
        logger.info("Search bar clicked and text entered");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).build().perform();
        action.sendKeys(Keys.ESCAPE).build().perform();
    }


}

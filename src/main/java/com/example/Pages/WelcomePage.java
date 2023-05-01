package com.example.Pages;

import com.example.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.example.driver.Driver.logger;

public class WelcomePage {
    private WebDriver driver;
    private final String senasteXpath = "/html/body/div[1]/div/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div/div[1]/div/div/div[1]/div/div/div[1]/div[1]/ul/li[2]/div/a";
    private final String searchBarXpath = "/html/body/div[1]/div/div[1]/div/div[2]/div[3]/div/div/div[1]/div/div/label/input";
    private final String profileXpath = "/html/body/div[1]/div/div[1]/div/div[2]/div[5]/div[1]/span/div/div[1]";
    private final String logoutXpath = "/html/body/div[1]/div/div[1]/div/div[2]/div[5]/div[2]/div/div/div[1]/div[1]/div/div/div/div/div/div/div/div/div[1]/div/div/div[1]/div[2]/div/div[5]/div";
    private final String welcomeTextXpath = "/html/body/div[1]/div/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div/div[2]/div/div/div[1]/span";
    @FindBy(xpath = welcomeTextXpath)
    private WebElement welcomeText;
    @FindBy(xpath = logoutXpath)
    private WebElement logout;
    @FindBy(xpath = profileXpath)
    private WebElement profile;
    @FindBy(xpath = searchBarXpath)
    private WebElement searchBar;


    public WelcomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = senasteXpath)
    private WebElement senaste;
    public void clickSenaste() {
            senaste.click();
            logger.info("Clicked on senaste");
    }
    public void clickAndEnterText(String text) {
            searchBar.sendKeys(text);
            searchBar.sendKeys("\n");
            logger.info("Searched for: " + text);
    }
    public void clickProfile() {
        profile.click();
        logger.info("Clicked on profile");
    }
    public void clickLogout() {
        logout.click();
        logger.info("Clicked on logout");
    }
    public String getSearchBarPath(){
        return searchBarXpath;
    }
    public String getProfilePath(){
        return profileXpath;
    }
    public String getLogoutPath(){
        return logoutXpath;
    }
    public String getWelcomeTextPath(){
        return welcomeTextXpath;
    }
    public String getWelcomeText(){
        return getWelcomeTextPath();
    }
    public WebElement getWelcomeTextElement(){
        return welcomeText;
    }





}

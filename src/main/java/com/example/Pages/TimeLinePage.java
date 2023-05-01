package com.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.time.Duration;

import static com.example.driver.Driver.logger;

public class TimeLinePage {
        private final String klickaPostXpath = "/html/body/div[1]/div/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div/div[2]/div/div/div/div[4]/div/div[2]/div/div/div/div[1]/div";
        private final String skrivPostXpath = "/html/body/div[1]/div/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/form/div/div[1]/div/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div[1]/p";
        private final String postaXpath = "/html/body/div[1]/div/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/form/div/div[1]/div/div/div/div[3]/div[2]/div";
        private final String profileXpath = "/html/body/div[1]/div/div[1]/div/div[2]/div[5]/div[1]/span/div/div[1]";
        private final String logoutXpath = "/html/body/div[1]/div/div[1]/div/div[2]/div[5]/div[2]/div/div[2]/div[1]/div[1]/div/div/div/div/div/div/div/div/div[1]/div/div/div[1]/div[2]/div/div[5]/div";
        private final String threedotsXpath = "/html/body/div[1]/div/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div/div[2]/div/div/div/div[4]/div/div[4]/div/div/div[1]/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[3]/div/div";
        private final String removePostXpath = "/html/body/div[1]/div/div[1]/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[1]/div/div/div/div/div/div/div[1]/div/div[8]";
        private final String moveToBinXpath= "/html/body/div[1]/div/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/div/div/div/div[3]/div/div/div/div/div[1]/div";
    private WebDriver driver;
    public TimeLinePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = moveToBinXpath)
    private WebElement klickmoveToBin;
    @FindBy(xpath = removePostXpath)
    private WebElement klickremovePost;
    @FindBy(xpath = threedotsXpath)
    private WebElement klickthreedots;
    @FindBy(xpath = logoutXpath)
    private WebElement klicklogout;
    @FindBy(xpath = profileXpath)
    private WebElement klickprofile;
    @FindBy (xpath = klickaPostXpath)
    private WebElement klickaPost;

    @FindBy (xpath = skrivPostXpath)
    private WebElement skrivPost;
    @FindBy (xpath = postaXpath)
    private WebElement posta;
    public void clickMoveToBin() {
        klickmoveToBin.click();
        logger.info("Clicked on Move to Bin");
    }
    public void clickRemovePost() {
        klickremovePost.click();
        logger.info("Clicked on Remove Post");
    }
    public void clickThreedots() {
        klickthreedots.click();
        logger.info("Clicked on Threedots");
    }
    public String getThreedotsXpath(){
        return threedotsXpath;
    }
    public String getRemovePostXpath(){
        return removePostXpath;
    }
    public String getMoveToBinXpath(){
        return moveToBinXpath;
    }

    public void clickProfile() {
            klickprofile.click();
            logger.info("Clicked on profile");
    }

    public void clickKlickaPost() {
            klickaPost.click();
            logger.info("Clicked on post");
    }
    public void skrivPost(String text) {

            skrivPost.sendKeys(text);
            skrivPost.sendKeys("\n");
            logger.info("Searched for: " + text);

    }
    public void clickPosta() {

            posta.click();
            logger.info("Posted Button clicked");

    }
    public String getKlickaPostXpath() {
        return klickaPostXpath;
    }
    public String getSkrivPostXpath() {
        return skrivPostXpath;
    }


    public String getPostaXpath() {
        return postaXpath;
    }
    public String getProfileXpath(){
        return profileXpath;
    }
}

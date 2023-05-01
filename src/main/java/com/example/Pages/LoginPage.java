package com.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.example.driver.Driver.logger;

public class LoginPage {
    private final WebDriver driver;
    private final String cookiescssSelector = "/html/body/div[3]/div[2]/div/div/div/div/div[4]/button[2]";
    private final String cookiesXpath = "/html/body/div[3]/div[2]/div/div/div/div/div[4]/button[2]";
    @FindBy(xpath = cookiesXpath)
    private WebElement cookies;
    @FindBy(id = "email")
    private WebElement userName;
    @FindBy(id = "pass")
    private WebElement password;
    @FindBy(id = "loginbutton")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickCookies() {
        logger.info("Clicked on cookies");
        cookies.click();
    }
    public void enterUserName(String text) {
        logger.info("Entered username: " + text);
        userName.sendKeys(text);
    }
    public void enterPassword(String text) {
        logger.info("Entered password: " + text);
        password.sendKeys(text);
    }
    public void clickLoginButton() {
        logger.info("Clicked on login button");
        loginButton.click();
    }
    public String getCookiesXpath() {
        return cookiesXpath;
    }
    public String getCookiescssSelector() {
        return cookiescssSelector;
    }

}

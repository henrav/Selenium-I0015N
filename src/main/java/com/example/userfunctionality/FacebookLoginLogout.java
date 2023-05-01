package com.example.userfunctionality;

import com.example.Config;
import com.example.Pages.LoginPage;
import com.example.Pages.WelcomePage;
import com.example.driver.Main;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;

public class FacebookLoginLogout {
    private WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private final LoginPage loginPage;
    private final WelcomePage welcomePage;
    private final WebDriverWait wait;

    public FacebookLoginLogout(WebDriver driver) {
        this.loginPage = new LoginPage(driver);
        this.welcomePage = new WelcomePage(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        logger.info("Initializing FacebookLoginLogout");
        this.driver = driver;
        this.driver.get("https://www.facebook.com/login/");
    }

    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000); // Convert seconds to milliseconds
        } catch (InterruptedException e) {
            logger.error("Interrupted during wait", e);
        }
    }

    public void loginFunctionality() {
        try {
            loginPage.clickCookies();
            //enter username and password and click login
            loginPage.enterUserName(Config.getEmail("email"));
            loginPage.enterPassword(Config.getPassword("password"));
            loginPage.clickLoginButton();
            //check if login is successful
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(welcomePage.getWelcomeText())));
            WebElement welcomeText = driver.findElement(By.xpath(welcomePage.getWelcomeText()));
            String text = welcomeText.getText();
            if (text.equals("Welcome to Facebook, Henrik")) {
                logger.info("Login successful");
            } else {
                logger.info("Login failed");
            }

    }catch (NoSuchElementException | TimeoutException e) {
        throw new RuntimeException(e);
    }
    }

    public void logout() {//logout thingy
        try {//click on profile
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(welcomePage.getProfilePath())));
            welcomePage.clickProfile();
            //click on logout
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(welcomePage.getLogoutPath())));
            welcomePage.clickLogout();
            //check if logout is successful, if login button is displayed then logout is successful
            WebElement loginButton = driver.findElement(By.name("login"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("login")));
            if (loginButton.isDisplayed()) {
                logger.info("Logout successful");
            } else {
                logger.info("Logout failed");
            }
        } catch (NoSuchElementException | TimeoutException e) {
            throw new RuntimeException(e);
        }


    }
}





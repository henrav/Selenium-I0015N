package com.example.post;
import com.example.Pages.TimeLinePage;
import com.example.Pages.WelcomePage;
import com.example.Config;

import com.example.userfunctionality.FacebookLoginLogout;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Objects;


public class Post {
    private WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(Post.class);
    private final FacebookLoginLogout facebookLoginLogout;
    private final WelcomePage welcomePage;
    private final TimeLinePage timeLinePage;
    private final WebDriverWait wait;


    public Post(WebDriver driver) {
        this.driver = driver;
        this.facebookLoginLogout = new FacebookLoginLogout(driver);
        this.welcomePage = new WelcomePage(driver);
        this.timeLinePage = new TimeLinePage(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        this.driver.get("https://www.facebook.com/login/");
    }

    //wait method
    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000); // Convert seconds to milliseconds
        } catch (InterruptedException e) {
            logger.error("Interrupted during wait", e);
        }
    }

    public void Posta() {
        try {
            //login functionality
            facebookLoginLogout.loginFunctionality();
            //click on timeline
            //each page has class of its own and the methods are in the pages
            welcomePage.clickSenaste();
            wait(2);
            if (driver.getPageSource().contains(Objects.requireNonNull(Config.getPost("message")))) {
                logger.info("Post is visible");
                RemovePost();
            } else {
                logger.info("Post is not visible");
            }
            //click on create post button
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(timeLinePage.getKlickaPostXpath())));
            timeLinePage.clickKlickaPost();
            //write post
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(timeLinePage.getSkrivPostXpath())));
            timeLinePage.skrivPost(Config.getPost("message"));
            //click on post button
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(timeLinePage.getPostaXpath())));
            timeLinePage.clickPosta();
            //check if post is visible
            wait(3);
            int i = 0;
            boolean postFound = false; // add a variable to keep track of whether the post has been found
            while (i < 5 && !postFound) { // add a check to exit the loop if the post is found
                driver.navigate().refresh();
                wait(1);
                if (driver.getPageSource().contains(Objects.requireNonNull(Config.getPost("message")))) {
                    logger.info("Post is visible");
                    postFound = true; // set the variable to true if the post is found
                    RemovePost();
                }
                i++;
            }
            if (!postFound) { // check if the post was not found after all refreshes
                logger.info("Post is not visible");
            }


        } catch (NoSuchElementException | TimeoutException e) {
            throw new RuntimeException(e);

        }
    }
        public void RemovePost(){
        logger.info("Removing post function starting");
        //click on three dots
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(timeLinePage.getThreedotsXpath())));
            timeLinePage.clickThreedots();
            //click on remove post
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(timeLinePage.getRemovePostXpath())));
            timeLinePage.clickRemovePost();
            //click on move to bin
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(timeLinePage.getMoveToBinXpath())));
            timeLinePage.clickMoveToBin();
            wait(3);
            //wait so page has time to "send" the post to bin
            //otherwise the post will not be sent to bin
            facebookLoginLogout.logout();
        } catch (NoSuchElementException | TimeoutException e) {
            throw new RuntimeException(e);
        }

    }

}

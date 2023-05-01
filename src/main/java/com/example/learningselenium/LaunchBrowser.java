package com.example.learningselenium;

import org.openqa.selenium.*;

public class LaunchBrowser {

    public void myTest(WebDriver driver) {

        // set url path
        driver.get("https://www.google.com");

        // click accept all before
        try {
            WebElement button = driver.findElement(By.id("L2AGLb"));
            button.click();
        } catch (NoSuchElementException e) {
            System.out.println("Button not found. It might not be available on your location.");
        }


        // Locate the search input element and enter the search query
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("ChatGPT");

        // Submit the search form by pressing the Enter key
        searchInput.submit();

        // Wait for the search results to load
        try {
            Thread.sleep(10000); // Adjust the sleep time if needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // get title after search
        String title = driver.getTitle();
        System.out.println(title);

        // close browser
        driver.quit();
    }

}

package com.example.driver;

import com.example.post.Post;
import com.example.searchfunctionality.SearchFunctionality;
import com.example.userfunctionality.FacebookLoginLogout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Driver {

    public static final Logger logger = LoggerFactory.getLogger(Driver.class);


    public Driver() {
        logger.info("Driver starting...  {}", Driver.class.getSimpleName());

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addArguments("--disable-dev-shm-usage"); // Overcomes limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        //uncomment the two lines below line to run the post functionality
        //Post post = new Post(driver);
        //post.Posta();

        //uncomment the two lines below line to run the search functionality
        //SearchFunctionality searchFunctionality = new SearchFunctionality(driver);
        //searchFunctionality.searchFunctionality();

        //uncomment the two lines below line to run the login functionality, although this function is already used in post and search
        //FacebookLoginLogout facebookLoginLogout = new FacebookLoginLogout(driver);
        //facebookLoginLogout.loginFunctionality();

        driver.quit();





    }


}

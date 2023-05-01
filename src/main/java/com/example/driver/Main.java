package com.example.driver;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import com.example.Config;
import com.example.Pages.SearchResultPage;
import com.example.userfunctionality.FacebookLoginLogout;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);



    public static void main(String[] args) {
        logger.info("");
        logger.info("Starting the application...");
        Driver driver = new Driver();

        logger.info("Application finished.");
    }
}


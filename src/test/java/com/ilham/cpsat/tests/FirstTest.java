package com.ilham.cpsat.tests;

import com.ilham.cpsat.runner.TestNGRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstTest extends TestNGRunner {
    private static final Logger logger = LogManager.getLogger(FirstTest.class.getName());
    WebDriver driver;

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void navigateToUrl() {
        driver.get("https://google.com");
        logger.info("Browser open...");
        //driver.close();
    }
}

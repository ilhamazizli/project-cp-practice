package com.ilham.cpsat.util;

import com.ilham.cpsat.base.TestBase;
import com.ilham.cpsat.constants.ProjectConstants;
import com.ilham.cpsat.thread.ThreadLocalSEDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


public class TestUtil extends TestBase {
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;

    private static final Logger logger = LogManager.getLogger(TestUtil.class.getName());


    public void switchToFrame() {
        ThreadLocalSEDriver.getDriver().switchTo().frame("mainpanel");
    }

    public static void waitForElementVisible(WebElement element, int timeoutSeconds){
        logger.trace("waitForElementVisible started");
        ThreadLocalSEDriver.getDriver().manage().timeouts().implicitlyWait(ProjectConstants.DEFAULT_SECOND, TimeUnit.MILLISECONDS);
        Wait wait= new FluentWait(ThreadLocalSEDriver.getDriver())
                .withTimeout(Duration.ofSeconds(timeoutSeconds))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementClickInterceptedException.class);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        logger.trace("waitForElementVisible completed and found element \""+element+"\"");




    }

}

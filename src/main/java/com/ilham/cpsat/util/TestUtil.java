package com.ilham.cpsat.util;

import com.ilham.cpsat.thread.ThreadLocalSEDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class TestUtil {
    private static final Logger logger = LogManager.getLogger(TestUtil.class.getName());

    public static void waitForElementToBeClickable(WebElement element, Duration duration) {
        new WebDriverWait(ThreadLocalSEDriver.getDriver(), duration)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementToBeVisible(WebElement element, Duration duration) {
        new WebDriverWait(ThreadLocalSEDriver.getDriver(), duration)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static String getCurrentWindow(WebDriver driver) {
        String windowId = null;
        try {
            windowId = driver.getWindowHandle();
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }
        return windowId;
    }

    public static List<String> getAllWindows(WebDriver driver) {
        return new ArrayList<>(driver.getWindowHandles());
    }

    public static void switchToWindow(WebDriver driver, String windowId) {
        try {
            driver.switchTo().window(windowId);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }
    }


}

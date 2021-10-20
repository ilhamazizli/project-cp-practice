package com.ilham.cpsat.thread;

import org.openqa.selenium.WebDriver;

public class ThreadLocalSEDriver {
    private static final ThreadLocal<WebDriver> TL_DRIVER = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return TL_DRIVER.get();
    }

    public static void setDriver(WebDriver driverInstance) {
        TL_DRIVER.set(driverInstance);
    }

}





package com.ilham.cpsat.runner;

import com.ilham.cpsat.base.TestBase;
import com.ilham.cpsat.thread.ThreadLocalSEDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestNGRunner {

    @BeforeTest(alwaysRun = true)
    public void testSetUp() {
        TestBase.initialization();
    }

    @AfterTest(alwaysRun = true)
    public void cleanUp() {
        ThreadLocalSEDriver.getDriver().close();
        ThreadLocalSEDriver.getDriver().quit();
    }


}

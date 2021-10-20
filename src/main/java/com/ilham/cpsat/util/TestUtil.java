package com.ilham.cpsat.util;

import com.ilham.cpsat.base.TestBase;
import com.ilham.cpsat.thread.ThreadLocalSEDriver;

public class TestUtil extends TestBase {
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;

    public void switchToFrame() {
        ThreadLocalSEDriver.getDriver().switchTo().frame("mainpanel");
    }

}

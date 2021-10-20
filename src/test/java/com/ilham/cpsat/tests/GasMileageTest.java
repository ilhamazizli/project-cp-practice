package com.ilham.cpsat.tests;

import com.ilham.cpsat.constants.ProjectConstants;
import com.ilham.cpsat.pages.GasMileagePage;
import com.ilham.cpsat.runner.TestNGRunner;
import com.ilham.cpsat.thread.ThreadLocalSEDriver;
import org.testng.annotations.Test;

public class GasMileageTest extends TestNGRunner {
    GasMileagePage gasMileagePage;

    @Test
    public void gasMileCalculateTest(){
        ThreadLocalSEDriver.getDriver().get(ProjectConstants.URL_GAS);
        gasMileagePage.gasCalculator();

    }

}

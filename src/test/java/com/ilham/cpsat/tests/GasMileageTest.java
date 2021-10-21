package com.ilham.cpsat.tests;

import com.ilham.cpsat.constants.ProjectConstants;
import com.ilham.cpsat.pages.GasMileagePage;
import com.ilham.cpsat.runner.TestNGRunner;
import com.ilham.cpsat.thread.ThreadLocalSEDriver;
import com.ilham.cpsat.util.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class GasMileageTest extends TestNGRunner {

    @Test(dataProvider = "DateDriven")
    public void gasMileCalculateTest(Object curReading, Object preReading, Object gasMile, Object expectedValue) {
        ThreadLocalSEDriver.getDriver().get(ProjectConstants.URL_GAS);
        GasMileagePage gasMileagePage = new GasMileagePage();
        String actualMileage = gasMileagePage.gasCalculator(curReading, preReading, gasMile);
        System.out.println(actualMileage);
        assertThat(actualMileage).isEqualTo(String.valueOf(expectedValue));

    }

    @DataProvider(name = "DateDriven")
    public Object[][] getDataFromExcel() {
        return ExcelReader.getTestData(ProjectConstants.TEST_DATA_SHEET_PATH, "Sheet1");


    }

}

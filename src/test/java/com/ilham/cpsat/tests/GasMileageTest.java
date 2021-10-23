package com.ilham.cpsat.tests;

import com.ilham.cpsat.constants.ProjectConstants;
import com.ilham.cpsat.pages.GasMileagePage;
import com.ilham.cpsat.runner.TestNGRunner;
import com.ilham.cpsat.thread.ThreadLocalSEDriver;
import com.ilham.cpsat.util.ExcelReader;
import org.opentest4j.AssertionFailedError;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GasMileageTest extends TestNGRunner {
     int rowIndex;

     @BeforeClass
     public void initializeRowIndex(){
         rowIndex=1;
     }

    @Test(dataProvider = "DateDriven")
    public void gasMileCalculateTest(Object curReading, Object preReading, Object gasMile, Object expectedValue, Object status) {
        ThreadLocalSEDriver.getDriver().get(ProjectConstants.URL_GAS);
        GasMileagePage gasMileagePage = new GasMileagePage();
        String actualMileage = gasMileagePage.gasCalculator(curReading, preReading, gasMile);
        System.out.println(actualMileage);
        try {
            assertThat(actualMileage).isEqualTo(String.valueOf(expectedValue));
            ExcelReader.writeData(ProjectConstants.TEST_DATA_SHEET_PATH,"Sheet1",rowIndex,4,"Passed");
        }catch (AssertionFailedError e){
            ExcelReader.writeData(ProjectConstants.TEST_DATA_SHEET_PATH,"Sheet1",rowIndex,4,"Failed");
        }
        rowIndex++;

    }

    @DataProvider(name = "DateDriven")
    public Object[][] getDataFromExcel() {
        return ExcelReader.getTestData(ProjectConstants.TEST_DATA_SHEET_PATH, "Sheet1");


    }

}

package com.ilham.cpsat.pages;

import com.ilham.cpsat.constants.ProjectConstants;
import com.ilham.cpsat.thread.ThreadLocalSEDriver;
import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.DecimalFormat;

public class GasMileagePage {

    public GasMileagePage() {
        PageFactory.initElements(ThreadLocalSEDriver.getDriver(), this);
    }

    @FindBy(css = "#uscodreading")
    WebElement currentOdoBox;

    @FindBy(id = "uspodreading")
    WebElement previousOdoBox;

    @FindBy(xpath = "//input[@id='usgasputin']")
    WebElement addGasTextBox;

    @FindBy(xpath = "(//input[@value='Calculate'])[1]")
    WebElement calculateBtn;

    @FindBy(xpath = "//b[contains(text(), 'mpg')]")
    WebElement resultMPG;

    public void gasCalculator(){
        double expected = (ProjectConstants.CURRENT_ODO-ProjectConstants.PREVIOUS_ODO)/ProjectConstants.GAS;
        String [] actualResult = resultMPG.getText().split("");
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");

        currentOdoBox.clear();
        currentOdoBox.sendKeys(String.valueOf(ProjectConstants.CURRENT_ODO));
        previousOdoBox.clear();
        previousOdoBox.sendKeys(String.valueOf(ProjectConstants.PREVIOUS_ODO));
        addGasTextBox.clear();
        addGasTextBox.sendKeys(String.valueOf(ProjectConstants.GAS));
        calculateBtn.click();

        if (String.valueOf(expected).equals((actualResult[0]))){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL!");
        }










    }



}
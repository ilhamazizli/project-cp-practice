package com.ilham.cpsat.pages;

import com.ilham.cpsat.thread.ThreadLocalSEDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GasMileagePage {

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

    public GasMileagePage() {
        PageFactory.initElements(ThreadLocalSEDriver.getDriver(), this);
    }

    public String gasCalculator(Object curOdo, Object preOdo, Object gas) {
        currentOdoBox.clear();
        currentOdoBox.sendKeys(String.valueOf(curOdo));
        previousOdoBox.clear();
        previousOdoBox.sendKeys(String.valueOf(preOdo));
        addGasTextBox.clear();
        addGasTextBox.sendKeys(String.valueOf(gas));
        calculateBtn.click();
        return resultMPG.getText();


    }


}
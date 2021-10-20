package com.ilham.cpsat.pages;

import com.ilham.cpsat.thread.ThreadLocalSEDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(css = ".btn.btn-primary.btn-xs-2.btn-shadow.btn-rect.btn-icon.btn-icon-left")
    WebElement loginLink;
    @FindBy(name = "email")
    WebElement emailUserNameBox;
    @FindBy(name = "password")
    WebElement passwordBox;
    @FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
    WebElement loginButton;
    @FindBy(xpath = "(//*[name()='image'])[1]")
    WebElement crmLogo;

    public LoginPage() {
        PageFactory.initElements(ThreadLocalSEDriver.getDriver(), this);
    }

    public HomePage login(String username, String password) {
        loginLink.click();
        emailUserNameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();
        return new HomePage();
    }

    public String validateLoginPageTitle() {
        return ThreadLocalSEDriver.getDriver().getTitle();
    }

    public boolean validateLogo() {
        return crmLogo.isDisplayed();
    }
}




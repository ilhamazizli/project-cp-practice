package com.ilham.cpsat.pages;

import com.ilham.cpsat.thread.ThreadLocalSEDriver;
import com.ilham.cpsat.util.JavaScriptUtil;
import com.ilham.cpsat.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class HamburgerMenuPage {
    @FindBy(xpath = "//li[contains(@class,'slideout-toggle menu-item-align-right')]//a[contains(@href,'#')]")
    WebElement hamburgerMenu;
    @FindBy(xpath = "//i[@class='eicon-close']")
    WebElement xIcon;

    public HamburgerMenuPage() {
        PageFactory.initElements(ThreadLocalSEDriver.getDriver(), this);
    }

    public HamburgerMenuPage loadExamSite() {
        ThreadLocalSEDriver.getDriver().get("https://mockexam1cpsat.agiletestingalliance.org/");
        return this;
    }

    public void clickOnHamburgerMenuLink() {
        xIcon.click();
        TestUtil.waitForElementToBeClickable(hamburgerMenu, Duration.ofSeconds(120));
        JavaScriptUtil.clickByJs(hamburgerMenu);
    }

    public List<WebElement> getAllLinkFromMenu() {
        return ThreadLocalSEDriver.getDriver().findElements(By.xpath("//ul[@id='menu-slideout-spacious']//li/a"));

    }


}





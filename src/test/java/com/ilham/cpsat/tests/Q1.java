package com.ilham.cpsat.tests;

import com.ilham.cpsat.pages.HamburgerMenuPage;
import com.ilham.cpsat.pages.SocialMediaPage;
import com.ilham.cpsat.runner.TestNGRunner;
import com.ilham.cpsat.thread.ThreadLocalSEDriver;
import com.ilham.cpsat.util.JavaScriptUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;


public class Q1 extends TestNGRunner {
    private static final Logger logger = LogManager.getLogger(Q1.class.getName());

    @Test(priority = 1)
    public void clickHamMenuAndGetAllLinksTest() {
        HamburgerMenuPage hamburgerMenuPage = new HamburgerMenuPage();
        hamburgerMenuPage.loadExamSite();
        hamburgerMenuPage.clickOnHamburgerMenuLink();
        List<WebElement> allLinks = hamburgerMenuPage.getAllLinkFromMenu();

        for (WebElement each : allLinks) {
            System.out.println(each.getAttribute("href"));
            System.out.println(JavaScriptUtil.getTextByJs(each));

        }

    }

    @Test(priority = 2)
    public void getAllSocialMediaUrlsTest() {
        HamburgerMenuPage hamburgerMenuPage = new HamburgerMenuPage();
        SocialMediaPage socialMediaPage = new SocialMediaPage();
        hamburgerMenuPage.loadExamSite();

        List<WebElement> allUrls = socialMediaPage.getAllSocialMediaLinks();

        for (WebElement each : allUrls) {
            System.out.println(each.getAttribute("href"));
            System.out.println(JavaScriptUtil.getTextByJs(each));

        }

    }

    @Test(priority = 2)
    public void getSocialLinksTest() {
        HamburgerMenuPage hamburgerMenuPage = new HamburgerMenuPage();
        SocialMediaPage socialMediaPage = new SocialMediaPage();
        hamburgerMenuPage.loadExamSite();
        hamburgerMenuPage.clickOnHamburgerMenuLink();


        List<WebElement> allUrls = socialMediaPage.getAllSocialMediaLinks();

        for (WebElement each : allUrls) {
            System.out.println(each.getAttribute("href"));
            System.out.println(JavaScriptUtil.getTextByJs(each));

        }

    }
    @Test(priority = 3)
    public void openInNewWindowTest() throws InterruptedException {
        HamburgerMenuPage hamburgerMenuPage = new HamburgerMenuPage();
        hamburgerMenuPage.loadExamSite();
        Thread.sleep(2500);
        hamburgerMenuPage.clickOnHamburgerMenuLink();
        Thread.sleep(2000);
        SocialMediaPage socialMediaPage = new SocialMediaPage();
        socialMediaPage.openSocialLinksInNewWindow();

    }


}
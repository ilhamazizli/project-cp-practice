package com.ilham.cpsat.tests;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.ilham.cpsat.constants.ProjectConstants;
import com.ilham.cpsat.pages.HomePage;
import com.ilham.cpsat.pages.LoginPage;
import com.ilham.cpsat.runner.TestNGRunner;
import com.ilham.cpsat.thread.ThreadLocalSEDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTest extends TestNGRunner {

    LoginPage loginPage;
    HomePage homePage;


    @BeforeClass
    public void setUp() {
        loginPage = new LoginPage();
    }

    @Test
    public void loginPageTitleTest() {
        String title = loginPage.validateLoginPageTitle();
        Shutterbug.shootPage(ThreadLocalSEDriver.getDriver()).save();
        Assert.assertEquals(title, "#1 Free CRM customer relationship management software cloud");
    }

    @Test
    public void crmLogoImageTest() {
        boolean flag = loginPage.validateLogo();
        Assert.assertTrue(flag);
    }

    @Test
    public void loginTest() {
        homePage = loginPage.login(ProjectConstants.USER_NAME, ProjectConstants.PASSWORD);

    }


}



package com.ilham.cpsat.tests;

import com.ilham.cpsat.constants.ProjectConstants;
import com.ilham.cpsat.pages.ContactsPage;
import com.ilham.cpsat.pages.HomePage;
import com.ilham.cpsat.pages.LoginPage;
import com.ilham.cpsat.runner.TestNGRunner;
import com.ilham.cpsat.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest extends TestNGRunner {
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;

    @BeforeClass
    public void setUp() {
        testUtil = new TestUtil();
        loginPage = new LoginPage();
        homePage = loginPage.login(ProjectConstants.USER_NAME, ProjectConstants.PASSWORD);
    }

    @Test(priority = 1)
    public void verifyHomePageTitleTest() {
        String homePageTitle = homePage.verifyHomePageTitle();
        Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home page title doesn't match");
    }

    @Test(priority = 2)
    public void verifyUserNameTest() {
        Assert.assertTrue(homePage.verifyCorrectUserName());
    }

    @Test(priority = 3)
    public void verifyContactsLinkTest() {
        contactsPage = homePage.clickContactsLink();
    }

}

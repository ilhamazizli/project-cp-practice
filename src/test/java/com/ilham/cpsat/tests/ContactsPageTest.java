package com.ilham.cpsat.tests;

import com.ilham.cpsat.constants.ProjectConstants;
import com.ilham.cpsat.pages.ContactsPage;
import com.ilham.cpsat.pages.HomePage;
import com.ilham.cpsat.pages.LoginPage;
import com.ilham.cpsat.runner.TestNGRunner;
import com.ilham.cpsat.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestNGRunner {
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;

    @BeforeMethod
    public void setUp() {
        testUtil = new TestUtil();
        contactsPage = new ContactsPage();
        loginPage = new LoginPage();
        homePage = loginPage.login(ProjectConstants.USER_NAME, ProjectConstants.PASSWORD);
        //testUtil.switchToFrame();
        homePage.clickContactsLink();

    }

    @Test(priority = 1)
    public void verifyContactsPageTest() {
        Assert.assertTrue(contactsPage.verifyContactLabel(), "Contacts page label missing on the page");
    }

    @Test(priority = 2)
    public void selectSingleContactTest() throws InterruptedException {
        contactsPage.selectContactsByName("Alan Shnayder");
    }

    @Test(priority = 3)
    public void selectMultipleContactsTest() {
        contactsPage.selectContactsByName("Alan Shnayder");
        contactsPage.selectContactsByName("Shaurma Doner");

    }

}

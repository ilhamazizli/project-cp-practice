package com.ilham.cpsat.pages;

import com.ilham.cpsat.base.TestBase;
import com.ilham.cpsat.thread.ThreadLocalSEDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy(xpath = "//span[@class='user-display']")
    WebElement userNamedElement;
    @FindBy(xpath = "//span[contains(text(), 'Contacts')]")
    WebElement contactsLink;
    @FindBy(xpath = "//span[contains(text(), 'Deals')]")
    WebElement dealsLink;
    @FindBy(xpath = "//span[contains(text(), 'Tasks')]")
    WebElement taskLink;
    @FindBy(xpath = "(//i[@aria-hidden='true'])[2]")
    WebElement addNewContactIcon;

    public HomePage() {
        PageFactory.initElements(ThreadLocalSEDriver.getDriver(), this);
    }

    public String verifyHomePageTitle() {
        return ThreadLocalSEDriver.getDriver().getTitle();
    }

    public ContactsPage clickContactsLink() {
        contactsLink.click();
        return new ContactsPage();
    }

    public DealsPage clickDealsLink() {
        dealsLink.click();
        return new DealsPage();
    }

    public TasksPage clickTasksLink() {
        taskLink.click();
        return new TasksPage();
    }

    public boolean verifyCorrectUserName() {
        return userNamedElement.isDisplayed();

    }

    public void clickOnNewNewContactLink() {
        Actions actions = new Actions(ThreadLocalSEDriver.getDriver());
        actions.moveToElement(contactsLink).perform();
        addNewContactIcon.click();

    }

}

package com.ilham.cpsat.pages;

import com.ilham.cpsat.base.TestBase;
import com.ilham.cpsat.thread.ThreadLocalSEDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends TestBase {

    @FindBy(xpath = "//span[contains(text(), 'Contacts')]")
    WebElement contactsLabelLink;
    @FindBy(xpath = "//a[text()='Alan Shnayder']/parent::td/preceding-sibling::td/div[@class='ui fitted read-only checkbox']/input[@class='hidden']")
    WebElement contactTable;
    @FindBy(css = "input[name='first_name']")
    WebElement firstNameBox;
    @FindBy(css = "input[name='last_name']")
    WebElement lastNameBox;
    @FindBy(xpath = "//input[@placeholder='Email address']")
    WebElement emailBox;

    public ContactsPage() {
        PageFactory.initElements(ThreadLocalSEDriver.getDriver(), this);
    }

    public boolean verifyContactLabel() {
        return contactsLabelLink.isDisplayed();
    }

    public void selectContactsByName(String name) {
        ThreadLocalSEDriver.getDriver().findElement(By.xpath("//a[text()='" + name + "']/parent::td/preceding-sibling::td/" +
                "div[@class='ui fitted read-only checkbox']/input[@class='hidden']")).click();
    }

    public void createNewContact() {
        //https://www.youtube.com/watch?v=H2-3w-GQZ3g&list=PLFGoYjJG_fqq6cHeqfsDes3pdVh3kpl74&index=5
        //12 50


    }


}





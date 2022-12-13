package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class BankManagerLoginPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[1]/button[1]")
    WebElement clickAddCustomer;

    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[1]/button[2]")
    WebElement clickOpenAccount;


    //This method click On "Add Customer" Tab
    public void clickOnAddCustomer() {
        Reporter.log("Click On 'Add Customer' Tab" + clickAddCustomer.toString());
        mouseHoverToElementAndClick(clickAddCustomer);
        CustomListeners.test.log(Status.PASS,"Click On 'Add Customer' Tab");

    }
    //This method click On "Open Account" Tab
    public void clickOnOpenAccount() {
        Reporter.log("Click On 'Open Account' Tab" + clickAddCustomer.toString());
        mouseHoverToElementAndClick(clickOpenAccount);
        CustomListeners.test.log(Status.PASS,"Click On 'Open Account");
    }
}

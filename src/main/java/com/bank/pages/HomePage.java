package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import javafx.scene.control.Tab;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement clickBankMangerLogin;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement clickLoginTab;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Home')]")
    WebElement clickOnHome;

    // This method to click On "Bank Manager Login" Tab
    public void clickOnBankManagerLoginTab(){
        Reporter.log("Click On 'Bank Manager Login' Tab "+ clickBankMangerLogin.toString());
        mouseHoverToElementAndClick(clickBankMangerLogin);
        CustomListeners.test.log(Status.PASS, "Click on 'Bank Manager Login'");
    }

    //This method click on "Customer Login" Tab
    public void clickOnCustomerLogInTab(){
        Reporter.log("Click On 'Customer Login' Tab "+ clickLoginTab.toString());
        mouseHoverToElementAndClick(clickLoginTab);
        CustomListeners.test.log(Status.PASS, "Click on 'Customer Login'");
    }
    //This method click on "Home" Tab
    public void clickOnHomeTab(){
        Reporter.log("Click On 'Home' Tab "+ clickOnHome.toString());
        mouseHoverToElementAndClick(clickOnHome);
        CustomListeners.test.log(Status.PASS, "Click on 'Home' Tab");
    }
}

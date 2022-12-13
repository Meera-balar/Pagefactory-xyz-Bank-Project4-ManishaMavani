package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class OpenAccountPage extends Utility {
    @CacheLookup
    @FindBy(id = "userSelect")
    WebElement searchCustomer;

    @CacheLookup
    @FindBy(id = "currency")
    WebElement currency;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Process')]")
    WebElement clickProcess;

    //	Search customer that created in first test
    public void searchCustomerName(String customerName){
        Reporter.log("Search customer that created before as " + searchCustomer.toString());
        clickOnElement(searchCustomer);
        selectByVisibleTextFromDropDown(searchCustomer,customerName);
        CustomListeners.test.log(Status.PASS, "Search customer that created as " + customerName);
    }

    //	Select currency "Pound"
    public void selectCurrencyPound(String currencyName){
        Reporter.log("Select currency 'Pound' " + currency.toString());
        clickOnElement(currency);
        selectByVisibleTextFromDropDown(currency,currencyName);
        CustomListeners.test.log(Status.PASS, "Select currency 'Pound'");
    }
    //	click on "process" button
    public void clickOnProcessButton(){
        Reporter.log("Click on 'process' button " + currency.toString());
        mouseHoverToElementAndClick(clickProcess);
        CustomListeners.test.log(Status.PASS, "Click on 'process' button ");
    }
    //	popup displayed
    //	verify message "Account created successfully"
    public String getPopupMessage(){
        Reporter.log("Verify message 'Account created successfully'" + getTextFromAlert());
        CustomListeners.test.log(Status.PASS, "Verify message 'Account created successfully'" + getTextFromAlert());
        return getTextFromAlert();
    }
    //	click on "ok" button on popup.
    public void clickOnOkButtonOfPopUp(){
        Reporter.log("Click on 'ok' button on popup.");
        acceptAlert();
        CustomListeners.test.log(Status.PASS, "Click on 'ok' button on popup.");

    }
}

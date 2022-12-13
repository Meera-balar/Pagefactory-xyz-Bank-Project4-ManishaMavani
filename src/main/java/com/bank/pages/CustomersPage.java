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

public class CustomersPage extends Utility {
    @CacheLookup
    @FindBy(id = "userSelect")
    WebElement  searchCustomer;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement clickLogIn;

    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'Your Name :')]")
    WebElement nameText;

    //This method search customer that  created before
    public void searchCustomer(String text){
        Reporter.log("Search customer that you created" + searchCustomer.toString());
        selectByVisibleTextFromDropDown(searchCustomer,text);
        CustomListeners.test.log(Status.PASS,"Search customer that you created");
    }
    //This method click on "Login" Button
    public void clickOnLoginButton(){
        Reporter.log("Click on 'Login' Button" + searchCustomer.toString());
        mouseHoverToElementAndClick(clickLogIn);
        CustomListeners.test.log(Status.PASS,"Click on 'Login' Button");
    }
    //This method verify "Your Name" text displayed
    public String verifyYourNameText(){
        Reporter.log("Verify 'Your Name' text is displayed" + searchCustomer.toString());
        CustomListeners.test.log(Status.PASS,"Verify 'Your Name' text is displayed");
        return getTextFromElement(nameText);
    }
}

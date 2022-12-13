package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddCustomerPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstNameField;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastNameField;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postcodeField;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Add Customer']")
    WebElement clickAddCustomerButton;

    //This method is for enter FirstName
    public void enterFirstName(String firstName){
        Reporter.log("Enter firstname " + firstName+ " to firstname field " + firstNameField.toString());
        sendTextToElement(firstNameField,firstName);
        CustomListeners.test.log(Status.PASS, "Enter firstName " + firstName);
    }

    //This method is for enter LastName
    public void enterLastName(String lastName){
        Reporter.log("Enter lastName " + lastName+ " to lastName field " + lastNameField.toString());
        sendTextToElement(lastNameField,lastName);
        CustomListeners.test.log(Status.PASS, "Enter lastName " + lastName);
    }
    //This method is for enter PostCode
    public void enterPostcode(String postcode)  {
        Reporter.log("Enter postcode " + postcodeField + " to postcode field " + lastNameField.toString());
        sendTextToElement(postcodeField,postcode);
        CustomListeners.test.log(Status.PASS, "Enter postcode " + postcode);
    }

    //This method click On "Add Customer" Button
    public void clickOnAddCustomerButton(){
        Reporter.log("Click On 'Add Customer' Button " + clickAddCustomerButton.toString());
        mouseHoverToElementAndClick(clickAddCustomerButton);
        CustomListeners.test.log(Status.PASS, "Click On 'Add Customer' Button ");
    }
    //	popup display
    //This method verify message "Customer added successfully"
    public String getPopupMessage(){
        Reporter.log("Verify message 'Customer added successfully' is display" + clickAddCustomerButton.toString());
        CustomListeners.test.log(Status.PASS, "Verify message 'Customer added successfully'");
        return getTextFromAlert();
    }
    //	click on "ok" button on popup.
    public void clickOnOkButtonOfPopUp(){
        acceptAlert();}

}

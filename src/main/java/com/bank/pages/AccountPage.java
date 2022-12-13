package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AccountPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement logoutText;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement clickLogOut;

    @CacheLookup
    @FindBy(xpath = "//div[@class='borderM box padT20 ng-scope']//button[2]")
    WebElement clickDeposit;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement enterAmountField;
    @CacheLookup
    @FindBy(xpath = "//button[text()='Deposit']")
    WebElement clickDepositButton;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement depositSuccessMessage;

    @CacheLookup
    @FindBy(xpath = "//div[@class='borderM box padT20 ng-scope']//button[3]")
    WebElement clickWithdraw;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement enterAmountField2;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Withdraw']")
    WebElement clickWithdrawButton;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Transaction successful')]")
    WebElement transactionSuccessMessage;

    //This method will verify "Logout" Tab displayed.
    public String checkLogoutTabDisplay() {
        Reporter.log("Verify 'Logout' Tab is displayed." + logoutText.toString());
        CustomListeners.test.log(Status.PASS,"Verify 'Logout' Tab is displayed");
        return getTextFromElement(logoutText);
    }

    //click on "Logout"
    public void clickOnLogoutTab() {
        Reporter.log("Click on 'Logout' Tab" + clickLogOut.toString());
        mouseHoverToElementAndClick(clickLogOut);
        CustomListeners.test.log(Status.PASS,"Click on 'Logout'");
    }
    //click on "Deposit" Tab

    public void clickOnDepositTab(){
        Reporter.log("Click on 'Deposit' Tab" + clickDeposit.toString());
        mouseHoverToElementAndClick(clickDeposit);
        CustomListeners.test.log(Status.PASS,"Click on 'Deposit' Tab");
    }

    //Enter amount 100
    public void enterAmountToDeposit(String amount){
        Reporter.log("Enter amount "+ amount + "for a deposit" + clickDeposit.toString());
        CustomListeners.test.log(Status.PASS,"Enter amount " + amount);
        sendTextToElement(enterAmountField,amount);
    }

    //click on "Deposit" Button
    public void clickOnDepositButton(){
        Reporter.log("Click on 'Deposit' button" + clickDepositButton.toString());
        clickOnElement(clickDepositButton);
        CustomListeners.test.log(Status.PASS,"Click on 'Deposit' button");
    }

    //verify message "Deposit Successful"
    public String getDepositSuccessfulMessage(){
        Reporter.log("verify message 'Deposit Successful' is display" + depositSuccessMessage.toString());
        CustomListeners.test.log(Status.PASS,"verify message 'Deposit Successful'");
        return getTextFromElement(depositSuccessMessage);

    }

    //click on "Withdraw" Tab
    public void clickOnWithdrawTab(){
        Reporter.log("Click on 'Withdraw' Tab" + clickWithdraw.toString());
        mouseHoverToElementAndClick(clickWithdraw);
        CustomListeners.test.log(Status.PASS,"Click on 'Withdraw' Tab");
    }

    //Enter amount 50
    public void enterAmountToWithdraw(String amount){
        Reporter.log("Enter amount "+ amount + "to be withdraw" + clickDeposit.toString());
        clickOnElement(enterAmountField2);
        sendTextToElement(enterAmountField2,amount);
        CustomListeners.test.log(Status.PASS,"Enter amount " + amount);
    }

    //click on "Withdraw" button
    public void clickOnWithdrawButton(){
        Reporter.log("Click on 'Withdraw' button" + clickWithdrawButton.toString());
        mouseHoverToElementAndClick(clickWithdrawButton);
        CustomListeners.test.log(Status.PASS,"Click on 'Withdraw' button");
    }

    //verify message "Transaction Successful"
    public String getTransactionSuccessfulMessage(){
        Reporter.log("Verify message 'Transaction Successful' is display" + transactionSuccessMessage.toString());
        CustomListeners.test.log(Status.PASS,"Verify message 'Transaction Successful'");
        return getTextFromElement(transactionSuccessMessage);
    }
}

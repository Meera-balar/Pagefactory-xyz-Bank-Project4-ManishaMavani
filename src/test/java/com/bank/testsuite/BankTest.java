package com.bank.testsuite;

import com.bank.customlisteners.CustomListeners;
import com.bank.pages.*;
import com.bank.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class BankTest extends BaseTest {
    HomePage homePage = new HomePage();
    BankManagerLoginPage bankManagerLoginPage;
    AddCustomerPage addCustomerPage;
    OpenAccountPage openAccountPage;

    CustomersPage customersPage;
    AccountPage accountPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        bankManagerLoginPage = new BankManagerLoginPage();
        addCustomerPage = new AddCustomerPage();
        openAccountPage = new OpenAccountPage();
        customersPage = new CustomersPage();
        accountPage = new AccountPage();
    }
    @Test(groups = {"sanity","regression"})
    public void bankManagerShouldAddCustomerSuccessfully(){
        homePage.clickOnBankManagerLoginTab();
        bankManagerLoginPage.clickOnAddCustomer();
        addCustomerPage.enterFirstName("Manisha");
        addCustomerPage.enterLastName("Mavani");
        addCustomerPage.enterPostcode("GJ5 0O7");
        addCustomerPage.clickOnAddCustomerButton();
        Assert.assertTrue(addCustomerPage.getPopupMessage().contains("Customer added successfully"),"Customer not added successfully");
        addCustomerPage.clickOnOkButtonOfPopUp();
    }
    @Test(groups = {"smoke","regression"})
    public void bankManagerShouldOpenAccountSuccessfully(){
        homePage.clickOnBankManagerLoginTab();
        bankManagerLoginPage.clickOnAddCustomer();
        addCustomerPage.enterFirstName("Manisha");
        addCustomerPage.enterLastName("Mavani");
        addCustomerPage.enterPostcode("GJ5 0O7");
        addCustomerPage.clickOnAddCustomerButton();
        addCustomerPage.clickOnOkButtonOfPopUp();
        bankManagerLoginPage.clickOnOpenAccount();
        openAccountPage.searchCustomerName("Manisha Mavani");
        openAccountPage.selectCurrencyPound("Pound");
        openAccountPage.clickOnProcessButton();
        Assert.assertTrue(openAccountPage.getPopupMessage().contains("Account created successfully"),"Customer not added successfully");
        openAccountPage.clickOnOkButtonOfPopUp();
    }
    @Test(groups = "regression")
    public void customerShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        homePage.clickOnBankManagerLoginTab();
        bankManagerLoginPage.clickOnAddCustomer();
        addCustomerPage.enterFirstName("Manisha");
        addCustomerPage.enterLastName("Mavani");
        addCustomerPage.enterPostcode("GJ5 0O7");
        addCustomerPage.clickOnAddCustomerButton();
        addCustomerPage.clickOnOkButtonOfPopUp();
        bankManagerLoginPage.clickOnOpenAccount();
        openAccountPage.searchCustomerName("Manisha Mavani");
        openAccountPage.selectCurrencyPound("Pound");
        openAccountPage.clickOnProcessButton();
        openAccountPage.clickOnOkButtonOfPopUp();
        homePage.clickOnHomeTab();
        homePage.clickOnCustomerLogInTab();
        customersPage.searchCustomer("Manisha Mavani");
        customersPage.clickOnLoginButton();
        Thread.sleep(500);
        Assert.assertEquals(accountPage.checkLogoutTabDisplay(),"Logout","Customer not login successfully");
        accountPage.clickOnLogoutTab();
        Assert.assertTrue(customersPage.verifyYourNameText().contains("Your Name"),"Customer not logout successfully");
    }
    @Test(groups = "regression")
    public void customerShouldDepositMoneySuccessfully(){
        homePage.clickOnBankManagerLoginTab();
        bankManagerLoginPage.clickOnAddCustomer();
        addCustomerPage.enterFirstName("Manisha");
        addCustomerPage.enterLastName("Mavani");
        addCustomerPage.enterPostcode("CV0 0OL");
        addCustomerPage.clickOnAddCustomerButton();
        addCustomerPage.clickOnOkButtonOfPopUp();
        bankManagerLoginPage.clickOnOpenAccount();
        openAccountPage.searchCustomerName("Manisha Mavani");
        openAccountPage.selectCurrencyPound("Pound");
        openAccountPage.clickOnProcessButton();
        openAccountPage.clickOnOkButtonOfPopUp();
        homePage.clickOnHomeTab();
        homePage.clickOnCustomerLogInTab();
        customersPage.searchCustomer("Manisha Mavani");
        customersPage.clickOnLoginButton();
        accountPage.clickOnDepositTab();
        accountPage.enterAmountToDeposit("100");
        accountPage.clickOnDepositButton();
        Assert.assertEquals(accountPage.getDepositSuccessfulMessage(),"Deposit Successful", "Deposit not successfully done");
    }
    @Test(groups = "regression")
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException{
        homePage.clickOnBankManagerLoginTab();
        bankManagerLoginPage.clickOnAddCustomer();
        addCustomerPage.enterFirstName("Manisha");
        addCustomerPage.enterLastName("Mavani");
        addCustomerPage.enterPostcode("CV0 0OL");
        addCustomerPage.clickOnAddCustomerButton();
        addCustomerPage.clickOnOkButtonOfPopUp();
        bankManagerLoginPage.clickOnOpenAccount();
        openAccountPage.searchCustomerName("Manisha Mavani");
        openAccountPage.selectCurrencyPound("Pound");
        openAccountPage.clickOnProcessButton();
        openAccountPage.clickOnOkButtonOfPopUp();
        homePage.clickOnHomeTab();
        homePage.clickOnCustomerLogInTab();
        customersPage.searchCustomer("Manisha Mavani");
        customersPage.clickOnLoginButton();
        accountPage.clickOnDepositTab();
        accountPage.enterAmountToDeposit("100");
        accountPage.clickOnDepositButton();
        Thread.sleep(500);
        accountPage.clickOnWithdrawTab();
        Thread.sleep(500);
        accountPage.enterAmountToWithdraw("50");
        accountPage.clickOnWithdrawButton();
        Thread.sleep(500);
        Assert.assertEquals(accountPage.getTransactionSuccessfulMessage(),"Transaction successful","Transaction not successfully done");
    }
}

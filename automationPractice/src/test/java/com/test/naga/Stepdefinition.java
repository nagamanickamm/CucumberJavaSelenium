package com.test.naga;

import com.test.naga.pages.*;
import com.test.naga.pages.subpages.OrderAddressTab;
import com.test.naga.pages.subpages.OrderPaymentTab;
import com.test.naga.pages.subpages.OrderShippingTab;
import com.test.naga.pages.subpages.OrderSummaryTab;
import com.test.naga.utils.driver.WebSiteBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Stepdefinition extends WebSiteBase {

    private HomePage homePage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;
    private OrderPage orderPage;
    private TShirtsPage tShirtsPage;
    private OrderSummaryTab orderSummaryTab;
    private OrderAddressTab orderAddressTab;
    private OrderShippingTab orderShippingTab;
    private OrderPaymentTab orderPaymentTab;
    private OrderHistoryPage orderHistoryPage;
    private MyDetails myDetails;

    @Before()
    public void init() {
        driverInit();
        homePage = PageFactory.initElements(driver, HomePage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        orderPage = PageFactory.initElements(driver, OrderPage.class);
        tShirtsPage = PageFactory.initElements(driver, TShirtsPage.class);
        orderSummaryTab = PageFactory.initElements(driver, OrderSummaryTab.class);
        orderShippingTab = PageFactory.initElements(driver, OrderShippingTab.class);
        orderAddressTab = PageFactory.initElements(driver, OrderAddressTab.class);
        myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
        orderPaymentTab = PageFactory.initElements(driver, OrderPaymentTab.class);
        orderHistoryPage = PageFactory.initElements(driver, OrderHistoryPage.class);

        myDetails = PageFactory.initElements(driver, MyDetails.class);
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }


    @Given("Iam logged into AutomationPractice with username {string} password {string}")
    public void im_logged_into_automation_practice_with_username_password(String username, String password) {
        homePage.openLoginPage();
        loginPage.login(username, password);
    }

    @When("I go to TShirts Section")
    public void i_go_to_t_shirts_section() {
        myAccountPage.navigateToTShirtTab(driver);
    }

    @When("Order a TShirt")
    public void order_a_t_shirt() {
        tShirtsPage.AddItemToCart(driver);
    }

    @Then("Item Added to Cart")
    public void item_added_to_cart(io.cucumber.datatable.DataTable dataTable) {
        List<String> details = dataTable.asList();
        tShirtsPage.verifyItemOnCart(details, driver);
    }

    @When("I Proceed with Checkout")
    public void i_proceed_with_checkout() {
        tShirtsPage.checkout(driver);
    }

    @Then("Im on Order Summary Page named {string}")
    public void im_on_order_summary_page_named(String string, io.cucumber.datatable.DataTable dataTable) {
        List<String> details = dataTable.asList();
        orderSummaryTab.verifyItemOnCart(driver, string, details);
    }

    @When("I Proceed to Address Page")
    public void i_proceed_to_address_page() {
        orderSummaryTab.proceedNext(driver);
    }

    @Then("Im on Order Address Page named {string}")
    public void im_on_order_address_page_named(String string, io.cucumber.datatable.DataTable dataTable) {
        List<String> details = dataTable.asList();
        orderAddressTab.verifyAddressInfo(driver, string, details);
    }

    @When("I Proceed to Shipping Page")
    public void i_proceed_to_shipping_page() {
        orderAddressTab.proceedNext(driver);
    }

    @Then("Im on Order Shipping Page named {string}")
    public void im_on_order_shipping_page_named(String string, io.cucumber.datatable.DataTable dataTable) {
        orderShippingTab.verifyShippingDetails(driver);
    }

    @When("I Proceed to Payments Page")
    public void i_proceed_to_payments_page() {
        orderShippingTab.setAgreeBoxAndProceedNext();
    }

    @Then("Im on Order Payments Page named {string}")
    public void im_on_order_payments_page_named(String string, io.cucumber.datatable.DataTable dataTable) {
        orderPaymentTab.verifyItemSummary();
    }

    @When("I complete the Payment")
    public void i_complete_the_payment() {
        orderPaymentTab.proceedPayment();
    }

    @Then("Im on Order Acknowledgement Page")
    public void im_on_order_acknowledgement_page(io.cucumber.datatable.DataTable dataTable) {
        orderPaymentTab.verifyAcknowledgement();
    }

    @When("I go back to MyAccounts")
    public void i_go_back_to_my_accounts() {
        orderPage.goToMyAccount();
    }

    @When("I go to My Order History")
    public void i_go_to_my_order_history() {
        myAccountPage.navigateToOrderHistory();
    }

    @Then("I see my Recent Order Details for {string} and status {string}")
    public void i_see_my_recent_order_details_for_and_status(String string, String string2) {
        orderHistoryPage.verifyHistory();
    }

    @When("I go to My personal information page")
    public void iGoToMyPersonalInformationPage() {
        myAccountPage.navigateToMyDetails();
    }

    @Then("Im at My personal informational page")
    public void imAtMyPersonalInformationalPage() {
        myAccountPage.waitForTitleMatch(driver, myDetails.pageTitle);
    }

    @When("I change my firstname {string} {string}")
    public void iChangeMyFirstname(String firstName, String password) {
        myDetails.changeFirstName(firstName);
        myDetails.updatePersonalDetails(password);
    }

    @Then("My firstName is changed")
    public void myFirstNameIsChanged() {
        myDetails.verifySuccessMessage("Your personal information has been successfully updated.");
    }
}

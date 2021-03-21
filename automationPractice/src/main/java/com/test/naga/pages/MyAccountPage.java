package com.test.naga.pages;

import com.test.naga.utils.common.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {
    public String pageTitle = "MyAccount - My Store";

    //_______________________Contents/WebElements____________________________

    @FindBy(xpath = "//a[contains(@href,'id_category=5&controller=category')]")
    private WebElement tShirtTab;

    @FindBy(css = "a[title=\"Orders\"]")
    private WebElement link_OrderHistoryAndDetails;

    @FindBy(css = "a[title=\"Credit Slips\"]")
    private WebElement link_MyCreditSlips;

    @FindBy(css = "a[title=\"Information\"]")
    private WebElement link_MyPersonalDetails;

    @FindBy(css = "a[title=\"Addresses\"]")
    private WebElement link_MyAddress;

    @FindBy(css = "a[title=\"My wishlists\"]")
    private WebElement link_MyWishlists;


    //_______________________Actions/Methods____________________________

    public void navigateToMyDetails(){
        this.link_MyPersonalDetails.click();
    }
    public void navigateToTShirtTab(WebDriver driver){
        executeJavaScript(driver, tShirtTab);
    }
    public void navigateToOrderHistory(){
        this.link_OrderHistoryAndDetails.click();
    }
}

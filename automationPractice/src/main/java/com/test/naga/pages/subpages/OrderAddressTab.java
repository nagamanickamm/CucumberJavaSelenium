package com.test.naga.pages.subpages;

import com.test.naga.utils.common.PageBase;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OrderAddressTab extends PageBase {
    //_______________________Contents/WebElements____________________________
    @FindBy(css = ".step_current span")
    private WebElement tabName;
    @FindBy(id = "id_address_delivery")
    private WebElement addressDropDown;
    @FindBy(id = "addressesAreEquals")
    private WebElement useSameAddress;
    @FindBy(css = "#address_delivery li.address_title")
    private WebElement deliveryAddressTitle;
    @FindBy(css = "#address_delivery li.address_update")
    private WebElement deliveryUpdateButton;
    @FindBy(css = "#address_invoice li.address_title")
    private WebElement invoiceAddressTitle;
    @FindBy(css = "#address_invoice li.address_update")
    private WebElement invoiceUpdateButton;
    @FindBy(name = "processAddress")
    private WebElement proceedCheckoutButton;
    //_______________________Actions/Methods____________________________
    public void proceedNext(WebDriver driver){
        executeJavaScript(driver, proceedCheckoutButton);
    }
    public void verifyAddressInfo(WebDriver driver, String name, List<String> details) {
        Assert.assertEquals("Test Address", details.get(0) );
        Assert.assertEquals("1", details.get(1) );
        Assert.assertEquals("YOUR DELIVERY ADDRESS",details.get(2) );
        Assert.assertTrue(deliveryUpdateButton.isDisplayed());
        Assert.assertEquals("YOUR BILLING ADDRESS",details.get(3) );
        Assert.assertTrue(invoiceUpdateButton.isDisplayed());
    }
    public void waitForAddress(WebDriver driver) {
        waitForElement(driver, tabName);
    }
}

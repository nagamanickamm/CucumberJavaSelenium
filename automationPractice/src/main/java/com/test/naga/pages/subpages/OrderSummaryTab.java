package com.test.naga.pages.subpages;

import com.test.naga.utils.common.PageBase;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OrderSummaryTab extends PageBase {

    //_______________________Contents/WebElements____________________________

    @FindBy(css = ".step_current.first")
    private WebElement tabName;
    @FindBy(css = ".product-name a")
    private WebElement productName;
    @FindBy(css = ".cart_avail span")
    private WebElement availability;
    @FindBy(css = "td.cart_unit span span")
    private WebElement unitPrice;
    @FindBy(css = ".cart_quantity_input") //getValue
    private WebElement cartQty;
    @FindBy(css = "td.cart_total span")
    private WebElement cartTotal;
    @FindBy(css = ".cart_total_price .price")
    private WebElement totalProductPrice;
    @FindBy(css = ".cart_total_delivery .price")
    private WebElement totalDeliveryCost;
    @FindBy(css = ".cart_total_price .price")
    private WebElement totalPurchaseCost;
    @FindBy(id = "total_price")
    private WebElement netTotal;
    @FindBy(css = "ul.address.first_item.item.box")
    private WebElement mainAddress;
    @FindBy(css = ".address.first_item .page-subheading")
    private WebElement deliveryAddressTitle;
    @FindBy(css = ".address.first_item .address_name")
    private WebElement deliveryName;
    @FindBy(css = ".address.first_item .address_address1")
    private WebElement deliveryAddressLine1;
    @FindBy(css = ".address.first_item .address_city")
    private WebElement deliveryAddressLine2;
    @FindBy(css = ".address.first_item .address_phone")
    private WebElement deliveryPhone;
    @FindBy(css = ".address.first_item .address_phone_mobile")
    private WebElement deliveryMobile;
    @FindBy(css = ".address.last_item .page-subheading")
    private WebElement invoiceAddressTitle;
    @FindBy(css = ".address.last_item .address_name")
    private WebElement invoiceName;
    @FindBy(css = ".address.last_item .address_address1")
    private WebElement invoiceAddressLine1;
    @FindBy(css = ".address.last_item .address_city")
    private WebElement invoiceAddressLine2;
    @FindBy(css = ".address.last_item .address_phone")
    private WebElement invoicePhone;
    @FindBy(css = ".address.last_item .address_phone_mobile")
    private WebElement invoiceMobile;
    @FindBy(xpath = "//a[contains(@href,'controller=order&step=1')]")
    private WebElement proceedCheckoutButton;

    //_______________________Actions/Methods____________________________
    public void proceedNext(WebDriver driver){
        executeJavaScript(driver,proceedCheckoutButton);
    }
    public void verifyItemOnCart(WebDriver driver, String name , List<String> details){
        waitForSummary(driver);
        Assert.assertEquals(name, tabName.getText());
        Assert.assertEquals(details.get(0), productName.getAttribute("innerHTML"));
        Assert.assertEquals(details.get(1), availability.getText());
        Assert.assertEquals(details.get(2), cartQty.getAttribute("value"));
        Assert.assertEquals(details.get(3), unitPrice.getText());
        Assert.assertEquals(details.get(4), cartTotal.getText());
        Assert.assertEquals(details.get(5), totalProductPrice.getText());
        Assert.assertEquals(details.get(6), totalDeliveryCost.getText());
        Assert.assertEquals(details.get(7), totalPurchaseCost.getText());
        Assert.assertEquals(details.get(8), netTotal.getText());
        Assert.assertEquals(details.get(9), deliveryAddressTitle.getText());
        Assert.assertEquals(details.get(10), deliveryName.getText());
        Assert.assertEquals(details.get(11), deliveryAddressLine1.getText());
        Assert.assertEquals(details.get(12), deliveryAddressLine2.getText());
        Assert.assertEquals(details.get(13), deliveryPhone.getText());
        Assert.assertEquals(details.get(14), deliveryMobile.getText());
        Assert.assertEquals(details.get(15), invoiceAddressTitle.getText());
        Assert.assertEquals(details.get(16), invoiceName.getText());
        Assert.assertEquals(details.get(17), invoiceAddressLine1.getText());
        Assert.assertEquals(details.get(18), invoiceAddressLine2.getText());
        Assert.assertEquals(details.get(19), invoicePhone.getText());
        Assert.assertEquals(details.get(20), invoiceMobile.getText());
    }
    public void waitForSummary(WebDriver driver) {
        waitForElement(driver,tabName);
    }
}

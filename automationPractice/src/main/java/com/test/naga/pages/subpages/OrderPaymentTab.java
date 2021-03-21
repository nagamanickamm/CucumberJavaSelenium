package com.test.naga.pages.subpages;

import com.test.naga.utils.common.PageBase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OrderPaymentTab extends PageBase {
    //_______________________Contents/WebElements____________________________
    @FindBy(id = "step_end")
    private WebElement tabName;
    @FindBy(css = ".product-name a")
    private WebElement productName;
    @FindBy(css = ".cart_avail span")
    private WebElement availability;
    @FindBy(css = "td.cart_unit span span")
    private WebElement unitPrice;
    @FindBy(css = ".cart_quantity span") //getValue
    private WebElement cartQty;
    @FindBy(css = "td.cart_total")
    private WebElement cartTotal;
    @FindBy(id = "total_product")
    private WebElement totalProductPrice;
    @FindBy(id = "total_shipping")
    private WebElement totalDeliveryCost;
    @FindBy(id = "total_price")
    private WebElement netTotal;
    @FindBy(className = "bankwire")
    private WebElement bankWireTransfer;
    @FindBy(id="module-bankwire-payment")
    private WebElement bankWireTransferFrame;
    @FindBy(css=".cart_navigation button[type=\"submit\"]")
    private WebElement confirmButton;
    @FindBy(css = ".cheque-indent strong")
    private WebElement acknowledgementTitle;
    @FindBy(css = ".price strong")
    private WebElement price;
    @FindBy(css = ".page-subheading")
    private WebElement bankWirePaymentHeading;
    //_______________________Actions/Methods____________________________
    public void verifyAcknowledgement(List<String> details) {
        Assert.assertEquals(acknowledgementTitle.getText(), details.get(0));
        Assert.assertEquals(price.getText(), details.get(1));
    }
    public void proceedPayment(){
        bankWireTransfer.click();
        Assert.assertTrue(bankWireTransferFrame.isDisplayed());
        Assert.assertEquals(bankWirePaymentHeading.getText(), "BANK-WIRE PAYMENT.");
        confirmButton.click();
    }
    public void verifyItemSummary(String name , List<String> details){
        Assert.assertEquals(name, tabName.getText());
        Assert.assertEquals(details.get(0), productName.getAttribute("innerHTML"));
        Assert.assertEquals(details.get(1), availability.getText());
        Assert.assertEquals(details.get(2), cartQty.getText());
        Assert.assertEquals(details.get(3), unitPrice.getText());
        Assert.assertEquals(details.get(4), cartTotal.getText());
        Assert.assertEquals(details.get(5), totalProductPrice.getText());
        Assert.assertEquals(details.get(6), totalDeliveryCost.getText());
        Assert.assertEquals(details.get(7), netTotal.getText());
    }
}

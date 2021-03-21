package com.test.naga.pages.subpages;

import com.test.naga.utils.common.PageBase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    public void verifyAcknowledgement() {
        Assert.assertEquals(acknowledgementTitle.getText(), "Your order on My Store is complete.");
        Assert.assertEquals(price.getText(), "$18.51");
    }
    public void proceedPayment(){
        bankWireTransfer.click();
        Assert.assertTrue(bankWireTransferFrame.isDisplayed());
        Assert.assertEquals(bankWirePaymentHeading.getText(), "BANK-WIRE PAYMENT.");
        confirmButton.click();
    }
    public void verifyItemSummary(){
        Assert.assertEquals("05. Payment", tabName.getText());
        Assert.assertEquals("Faded...", productName.getAttribute("innerHTML"));
        Assert.assertEquals("In stock", availability.getText());
        Assert.assertEquals("1", cartQty.getText());
        Assert.assertEquals("$16.51", unitPrice.getText());
        Assert.assertEquals("$16.51", cartTotal.getText());
        Assert.assertEquals("$16.51", totalProductPrice.getText());
        Assert.assertEquals("$2.00", totalDeliveryCost.getText());
        Assert.assertEquals("$18.51", netTotal.getText());
    }
}

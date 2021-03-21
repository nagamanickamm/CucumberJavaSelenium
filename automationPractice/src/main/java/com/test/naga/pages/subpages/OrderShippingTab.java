package com.test.naga.pages.subpages;

import com.test.naga.utils.common.PageBase;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.locators.RelativeLocator;

public class OrderShippingTab extends PageBase {
    //_______________________Contents/WebElements____________________________
    @FindBy(css = ".step_current.four")
    private WebElement tabName;
    @FindBy(css = ".delivery_option_price")
    private WebElement deliveryPrice;
    @FindBy(id = "cgv")
    private WebElement agreeBox;
    @FindBy(css = "td strong")
    private WebElement myCarrierLabel;
    @FindBy(name = "processCarrier")
    private WebElement proceedCheckoutButton;
    //_______________________Actions/Methods____________________________
    public void verifyShippingDetails(WebDriver driver) {
        Assert.assertEquals("04. Shipping", tabName.getText());
        Assert.assertEquals("$2.00", deliveryPrice.getText() );
        Assert.assertEquals("My carrier", myCarrierLabel.getText() );
    }
    public void setAgreeBoxAndProceedNext(){
        agreeBox.click();
        proceedCheckoutButton.click();
    }
}

package com.test.naga.pages.subpages;

import com.test.naga.utils.common.PageBase;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.util.List;

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
    public void verifyShippingDetails(WebDriver driver, String name, List<String> details) {
        Assert.assertEquals(name, tabName.getText());
        Assert.assertEquals(details.get(0), deliveryPrice.getText() );
        Assert.assertEquals(details.get(1), myCarrierLabel.getText() );
    }
    public void setAgreeBoxAndProceedNext(){
        agreeBox.click();
        proceedCheckoutButton.click();
    }
}

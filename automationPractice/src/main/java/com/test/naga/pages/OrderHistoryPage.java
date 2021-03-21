package com.test.naga.pages;

import com.test.naga.utils.common.PageBase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryPage extends PageBase {

    public String pageTitle = "Order history - My Store";

    //_______________________Contents/WebElements____________________________
    @FindBy(css = ".first_item .color-myaccount")
    private WebElement reference;

    @FindBy(css = ".first_item .history_price")
    private WebElement historyPrice;

    @FindBy(css = ".first_item .history_state")
    private WebElement historyState;


    //_______________________Actions/Methods____________________________
    public void verifyHistory() {
        Assert.assertTrue(reference.getText().matches("[a-zA-Z]+"));
        Assert.assertEquals(historyPrice.getText(), "$18.51");
        Assert.assertEquals(historyState.getText(), "On backorder");
    }
}
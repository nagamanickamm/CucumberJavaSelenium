package com.test.naga.pages;

import com.test.naga.utils.common.PageBase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends PageBase {

    public String pageTitle = "Order - My Store";

    @FindBy(id = "summary_products_quantity")
    private WebElement summaryProducts;

    @FindBy(className = "account")
    private WebElement myAccount;

    public void verifyProductQty(int qty) {
        Assert.assertEquals(summaryProducts.getText(), qty + " Product");
    }
    public void goToMyAccount(){
        myAccount.click();
    }
}
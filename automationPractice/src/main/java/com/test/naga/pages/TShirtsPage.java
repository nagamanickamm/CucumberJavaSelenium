package com.test.naga.pages;

import com.test.naga.utils.common.PageBase;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TShirtsPage extends PageBase {

    public String pageTitle = "T-shirts - My Store";

    //_______________________Contents/WebElements____________________________

    @FindBy(className = ".product-container")
    private WebElement productContainer;

    @FindBy(css = ".product-container .product-name")
    private List<WebElement> allProducts;

    @FindBy(css = ".available-now link")
    private WebElement link_inStock;

    @FindBy(css = "a.ajax_add_to_cart_button")
    private WebElement addToCart;

    @FindBy(id = "layer_cart")
    private WebElement cartPopup;

    @FindBy(css = "[title=\"Close window\"]")
    private WebElement closePopUp;

    @FindBy(css = ".layer_cart_product h2")
    private WebElement okMessage;

    @FindBy(id = "layer_cart_product_title")
    private WebElement itemName;

    @FindBy(id = "layer_cart_product_attributes")
    private WebElement itemColor;

    @FindBy(id = "layer_cart_product_quantity")
    private WebElement itemQty;

    @FindBy(id = "layer_cart_product_price")
    private WebElement itemPrice;

    @FindBy(css = "a[title=\"Proceed to checkout\"]")
    private WebElement proceedCheckout;

    @FindBy(css = "span.ajax_block_products_total")
    private WebElement totalProductPrice;

    @FindBy(css = "span.ajax_cart_shipping_cost")
    private WebElement totalShippingCost;

    @FindBy(css = "span.ajax_block_cart_total")
    private WebElement totalPurchaseCost;

    //_______________________Actions/Methods____________________________

    public void AddItemToCart(WebDriver driver){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", addToCart);
    }

    public void verifyItemOnCart(List<String> itemSummary, WebDriver driver) {
        waitForPopUpCart(driver);
        Assert.assertTrue(cartPopup.isDisplayed());
        Assert.assertTrue(okMessage.isDisplayed());

        Assert.assertEquals(itemSummary.get(0), okMessage.getText());
        Assert.assertEquals(itemSummary.get(1), itemName.getText());
        Assert.assertEquals(itemSummary.get(2), itemColor.getText());
        Assert.assertEquals(itemSummary.get(3), itemQty.getText());
        Assert.assertEquals(itemSummary.get(4), itemPrice.getText());
        Assert.assertEquals(itemSummary.get(5), totalProductPrice.getText());
        Assert.assertEquals(itemSummary.get(6), totalShippingCost.getAttribute("innerHTML"));
        Assert.assertEquals(itemSummary.get(7), totalPurchaseCost.getAttribute("innerHTML"));
    }

    public void waitForPopUpCart(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return cartPopup.isDisplayed();
            }
        });
    }

    public void checkout(WebDriver driver){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", proceedCheckout);
    }
}

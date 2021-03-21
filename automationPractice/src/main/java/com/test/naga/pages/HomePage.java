package com.test.naga.pages;

import com.test.naga.utils.common.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

    public String pageTitle = "My Store";

    //_______________________Contents/WebElements____________________________

    @FindBy(css="a.login")
    private WebElement signInLink;

    //_______________________Actions/Methods____________________________

    public void openLoginPage(){
        signInLink.click();
    }
}

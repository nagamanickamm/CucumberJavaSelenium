package com.test.naga.pages;

import com.test.naga.utils.common.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {
    public String pageTitle = "Login - My Store";

    //_______________________Contents/WebElements____________________________

    @FindBy(id="email")
    private WebElement userName;

    @FindBy(id="passwd")
    private WebElement password;

    @FindBy(id="SubmitLogin")
    private WebElement submitLogin;

    //_______________________Actions/Methods____________________________

    public void login(String username, String password){
        this.userName.sendKeys(username);
        this.password.sendKeys(password);
        this.submitLogin.click();
    }
}

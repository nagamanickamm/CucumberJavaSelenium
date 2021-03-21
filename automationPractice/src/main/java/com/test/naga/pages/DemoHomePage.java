package com.test.naga.pages;

import com.test.naga.utils.common.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoHomePage extends PageBase {

        //////////////////////////////////////////////WEB ELEMENTS//////////////////////////////////////////////////////////
        @FindBy(name = "userName")
        private WebElement userName;

        @FindBy(name = "password")
        private WebElement password;

        @FindBy(name = "submit")
        private WebElement submit;

        public void login(String user, String pass) {
            //////////////////////////////////////////////BASE METHODS//////////////////////////////////////////////////////////
                userName.sendKeys(user);
                password.sendKeys(pass);
                submit.click();
        }
}

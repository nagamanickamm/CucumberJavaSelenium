package com.test.naga.pages;

import com.test.naga.utils.common.PageBase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyDetails extends PageBase {

    public String pageTitle = "Identity - My Store";

    //_______________________Contents/WebElements____________________________

    @FindBy(css = "//h1[contains(text(),'Your personal information')]")
    private WebElement header_YourPersonalInformation;
    @FindBy(css = "#id_gender2")
    private WebElement input_SocialTitle;
    @FindBy(css = "#firstname")
    private WebElement input_FirstName;
    @FindBy(css = "#lastname")
    private WebElement input_LastName;
    @FindBy(css = "#email")
    private WebElement input_Email;
    @FindBy(css = "#old_passwd")
    private WebElement input_CurrentPassword;
    @FindBy(css = "#passwd")
    private WebElement input_NewPassword;
    @FindBy(css = "#confirmation")
    private WebElement input_Confirmation;
    @FindBy(css = ".button[name=\"submitIdentity\"]")
    private WebElement button_Save;
    @FindBy(xpath = "//ul/li/a[contains(@href,'my-account')]")
    private WebElement link_BackToMyAccount;
    @FindBy(css = ".alert-success")
    private WebElement label_SuccessMessage;

    //_______________________Actions/Methods____________________________
    public void verifyPageDisplay() {
        Assert.assertEquals(true, header_YourPersonalInformation.isDisplayed());
    }
    public void changeFirstName(String firstName) {
        input_FirstName.clear();
        input_FirstName.sendKeys(firstName);
    }
    public void updatePersonalDetails(String password) {
        input_CurrentPassword.clear();
        input_CurrentPassword.sendKeys(password);
        button_Save.click();
    }
    public void verifySuccessMessage(String expectedMessage){
        Assert.assertEquals(true, label_SuccessMessage.isDisplayed());
        Assert.assertEquals(expectedMessage, label_SuccessMessage.getText().trim());
    }
    public void verifyFirstName(String firstName) {
        Assert.assertEquals(input_FirstName.getAttribute("value"), firstName);
    }
    public void navigateBackToMyAccount() {
        link_BackToMyAccount.click();
    }

}

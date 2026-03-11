package com.automation.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends PageObject {

    @FindBy(id = "displayName")
    private WebElement inputDisplayName;

    @FindBy(id = "email")
    private WebElement inputEmail;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(id = "confirmPassword")
    private WebElement inputConfirmPassword;

    @FindBy(css = "button[type='submit']")
    private WebElement buttonRegister;

    @FindBy(css = "a[href='/login']")
    private WebElement linkLogin;

    public RegisterPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void enterDisplayName(String name) {
        element(inputDisplayName).type(name);
    }

    public void enterEmail(String email) {
        element(inputEmail).type(email);
    }

    public void enterPassword(String password) {
        element(inputPassword).type(password);
    }

    public void enterConfirmPassword(String password) {
        element(inputConfirmPassword).type(password);
    }

    public void clickRegister() {
        element(buttonRegister).click();
    }

    public void clickLogin() {
        element(linkLogin).click();
    }
}

package com.automation.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageObject {

    @FindBy(name = "username")
    private WebElement inputUsername;

    @FindBy(name = "password")
    private WebElement inputPassword;

    @FindBy(css = "button[type='submit']")
    private WebElement buttonLogin;

    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void enterUsername(String username) {
        element(inputUsername).type(username);
    }

    public void enterPassword(String password) {
        element(inputPassword).type(password);
    }

    public void clickLogin() {
        element(buttonLogin).click();
    }
}

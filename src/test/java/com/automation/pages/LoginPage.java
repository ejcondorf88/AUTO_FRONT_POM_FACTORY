package com.automation.pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DefaultUrl("/login")
public class LoginPage extends PageObject {

  @FindBy(id = "email")
  private WebElementFacade inputEmail;

  @FindBy(id = "password")
  private WebElementFacade inputPassword;

  @FindBy(css = "button[type='submit']")
  private WebElementFacade buttonLogin;

  @FindBy(css = "a[href*='/register']")
  private WebElementFacade linkRegister;

  public void openLoginPage() {
    open();
    inputEmail.waitUntilVisible();
  }

  public void enterEmail(String email) {
    inputEmail.waitUntilClickable().type(email);
  }

  public void enterPassword(String password) {
    inputPassword.waitUntilEnabled().type(password);
  }

  public void clickLogin() {
    buttonLogin.waitUntilClickable().click();
  }

  public void clickRegister() {
    linkRegister.waitUntilClickable().click();
  }
}
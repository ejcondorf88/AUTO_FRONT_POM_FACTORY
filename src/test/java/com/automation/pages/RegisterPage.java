package com.automation.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import java.time.Duration;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageObject {

  @FindBy(id = "displayName")
  private WebElementFacade inputDisplayName;

  @FindBy(id = "email")
  private WebElementFacade inputEmail;

  @FindBy(id = "password")
  private WebElementFacade inputPassword;

  @FindBy(id = "confirmPassword")
  private WebElementFacade inputConfirmPassword;

  @FindBy(css = "button[type='submit']")
  private WebElementFacade buttonRegister;

  @FindBy(css = "a[href='/login']")
  private WebElementFacade linkLogin;

  public void enterDisplayName(String name) {
    inputDisplayName.withTimeoutOf(Duration.ofSeconds(10)).waitUntilClickable();
    inputDisplayName.clear();
    inputDisplayName.type(name);
  }

  public void enterEmail(String email) {
    inputEmail.waitUntilEnabled().type(email);
  }

  public void enterPassword(String password) {
    inputPassword.waitUntilEnabled().type(password);
  }

  public void enterConfirmPassword(String password) {
    inputConfirmPassword.waitUntilEnabled().type(password);
  }

  public void clickRegister() {
    buttonRegister.waitUntilClickable().click();
  }

  public void clickRegisterButton() {
    clickRegister();
  }

  public void clickLogin() {
    linkLogin.waitUntilClickable().click();
  }
}
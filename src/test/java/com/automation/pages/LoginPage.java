package com.automation.pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DefaultUrl("http://localhost:3000/login")
public class LoginPage extends PageObject {

  @FindBy(id = "email")
  private WebElementFacade inputEmail;

  @FindBy(id = "password")
  private WebElementFacade inputPassword;

  @FindBy(css = "button[type='submit']")
  private WebElementFacade buttonLogin;

  @FindBy(xpath = "//a[contains(@href,'/register') or contains(.,'Registr')]")
  private WebElementFacade linkRegister;

  public void openLoginPage() {
    open();
    withTimeoutOf(Duration.ofSeconds(15)).waitFor(ExpectedConditions.elementToBeClickable(By.id("email")));
  }

  public void enterEmail(String email) {
    waitFor(ExpectedConditions.urlContains("/login"));
    
    $ (By.id("email")).waitUntilClickable();
    waitABit(500); 
    $ (By.id("email")).clear();
    $ (By.id("email")).type(email);
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
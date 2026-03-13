package com.automation.steps;

import com.automation.pages.RegisterPage;
import com.automation.pages.LoginPage;
import net.serenitybdd.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.By;

public class RegisterSteps extends ScenarioSteps {

    private RegisterPage registerPage;
    private LoginPage loginPage;

    @Step("Register a new user with name {0} and email {1}")
    public void registerNewUser(String name, String email, String password) {
        loginPage.openLoginPage();
        loginPage.clickRegister();
        registerPage.enterDisplayName(name);
        registerPage.enterEmail(email);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);
        registerPage.clickRegister();
        loginPage.waitForRenderedElements(By.id("email"));
    }
}
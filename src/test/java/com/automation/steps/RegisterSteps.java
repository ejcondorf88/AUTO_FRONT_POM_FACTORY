package com.automation.steps;

import com.automation.pages.RegisterPage;
import net.serenitybdd.annotations.Step;

public class RegisterSteps {

    private RegisterPage registerPage;

    @Step("Register a new user with name {0} and email {1}")
    public void registerNewUser(String name, String email, String password) {
        registerPage.open();
        registerPage.enterDisplayName(name);
        registerPage.enterEmail(email);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);
        registerPage.clickRegisterButton();
    }
}
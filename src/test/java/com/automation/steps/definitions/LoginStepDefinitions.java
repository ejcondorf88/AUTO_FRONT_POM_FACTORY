package com.automation.steps.definitions;

import com.automation.steps.LoginSteps;
import com.automation.utils.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class LoginStepDefinitions {

    @Steps
    private LoginSteps loginSteps;

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        loginSteps.openLoginPage();
    }

    @When("the user authenticates with valid credentials")
    public void theUserAuthenticatesWithValidCredentials() {
        loginSteps.loginWithCredentials(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);
    }

    @Then("the user should see the application dashboard")
    public void theUserShouldSeeTheApplicationDashboard() {
        loginSteps.verifyDashboardIsDisplayed();
    }

    @When("the user decides to logout")
    public void theUserDecidesToLogout() {
        loginSteps.logout();
    }
}

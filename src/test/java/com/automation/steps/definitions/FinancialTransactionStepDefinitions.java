package com.automation.steps.definitions;

import com.automation.steps.LoginSteps;
import com.automation.steps.RegisterSteps;
import com.automation.steps.TransactionSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Steps;

public class FinancialTransactionStepDefinitions {

    @Steps
    private RegisterSteps registerSteps;

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private TransactionSteps transactionSteps;

    @Given("the visitor registers with name {string}, email {string}, and password {string}")
    public void registerVisitor(String name, String email, String password) {
        registerSteps.registerNewUser(name, email, password);
    }

    @When("the user logs in with email {string} and password {string}")
    public void loginUser(String email, String password) {
        loginSteps.loginWithCredentials(email, password);
    }

    @And("accesses the transactions module")
    public void openTransactionsModule() {
        transactionSteps.openTransactionsModule();
    }

    @And("registers a {string} transaction with description {string} for an amount of {int} and date {string}")
    public void registerTransaction(String type, String description, Integer amount, String date) {
        transactionSteps.registerTransaction(type, description, String.valueOf(amount), date);
    }

    @Then("the user should see the transaction {string} with amount {int} in the list")
    public void verifyTransactionInList(String description, Integer amount) {
        transactionSteps.verifyTransactionInList(description, amount);
    }
}
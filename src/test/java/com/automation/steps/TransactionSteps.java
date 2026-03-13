package com.automation.steps;

import com.automation.pages.TransactionsPage;
import com.automation.pages.DashboardPage;
import net.serenitybdd.annotations.Step;
import org.assertj.core.api.Assertions;

import java.util.Random;

public class TransactionSteps {

    private TransactionsPage transactionsPage;

    private DashboardPage dashboardPage;

    @Step("Open the transactions module from the dashboard")
    public void openTransactionsModule() {
        dashboardPage.openSidebar();
        dashboardPage.goToTransactions();
    }

    @Step("Register a {0} transaction with description {1} and amount {2}")
    public void registerTransaction(String type, String description, String amount, String date) {
        transactionsPage.clickNewTransaction();
        transactionsPage.selectTransactionType(type);
        
        String[] defaultCategories = {"Alimentación", "Transporte", "Vivienda", "Salud", "Educación", "Entretenimiento", "Otros"};
        String category = defaultCategories[new Random().nextInt(defaultCategories.length)];
        transactionsPage.selectCategory(category);
        
        transactionsPage.enterDescription(description);
        transactionsPage.enterAmount(amount);
        transactionsPage.enterDate(date);
        transactionsPage.clickSubmit();
    }

    @Step("Verify that the transaction {0} and amount {1} appear in the transactions list")
    public void verifyTransactionInList(String description, Integer amount) {
        String expectedAmount = String.valueOf(amount);
        Assertions.assertThat(transactionsPage.getTransactionDescriptions())
                .anyMatch(text -> {
                    String normalizedText = text.replaceAll("[.$ ,]", "");
                    return text.contains(description) && normalizedText.contains(expectedAmount);
                });
    }
}
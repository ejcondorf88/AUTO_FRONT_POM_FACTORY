package com.automation.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionsPage extends PageObject {

    @FindBy(xpath = "//button[contains(., 'Nueva Transacción')]")
    private WebElement buttonOpenModal;

    @FindBy(name = "description")
    private WebElement inputDescription;

    @FindBy(name = "amount")
    private WebElement inputAmount;

    @FindBy(name = "date")
    private WebElement inputDate;

    @FindBy(xpath = "//button[@type='submit' and contains(., 'Crear Transacción')]")
    private WebElement buttonSubmit;

    @FindBy(css = "table tbody tr")
    private List<WebElement> transactionRows;

    // Custom Selects (Radix UI / Shadcn)
    private String xpathSelectTrigger = "//label[text()='%s']/following-sibling::button";
    private String xpathSelectOption = "//div[@role='option']//span[text()='%s']";

    public TransactionsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void clickNewTransaction() {
        element(buttonOpenModal).click();
    }

    public void selectType(String type) {
        String capitalized = type.substring(0, 1).toUpperCase() + type.substring(1).toLowerCase();
        findAll(By.tagName("select")).get(0).selectByVisibleText(capitalized);
    }

    public void selectCategory(String category) {
        String capitalized = category.substring(0, 1).toUpperCase() + category.substring(1).toLowerCase();
        findAll(By.tagName("select")).get(1).selectByVisibleText(capitalized);
    }

    public void enterDescription(String description) {
        element(inputDescription).type(description);
    }

    public void enterAmount(String amount) {
        element(inputAmount).type(amount);
    }

    public void enterDate(String date) {
        element(inputDate).type(date);
    }

    public void clickSubmit() {
        element(buttonSubmit).click();
    }

    public List<String> getTransactionDescriptions() {
        return transactionRows.stream()
                .map(row -> row.getText())
                .collect(Collectors.toList());
    }
}

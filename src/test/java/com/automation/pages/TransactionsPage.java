package com.automation.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionsPage extends PageObject {

    @FindBy(xpath = "//button[contains(.,'Transacci') or .//*[contains(@class, 'lucide-plus')]]")
    private WebElementFacade buttonOpenModal;

    @FindBy(name = "description")
    private WebElementFacade inputDescription;

    @FindBy(name = "amount")
    private WebElementFacade inputAmount;

    @FindBy(name = "date")
    private WebElementFacade inputDate;

    @FindBy(css = "button[type='submit']")
    private WebElementFacade buttonSubmit;

    public void clickNewTransaction() {
        buttonOpenModal.waitUntilClickable().click();
        inputDescription.waitUntilVisible();
    }

    private void interactWithCustomSelect(String labelPart, String optionSearchText) {
        WebElementFacade label = $(By.xpath("//label[contains(.,'" + labelPart + "')]"));
        String controlId = label.getAttribute("for");
        WebElementFacade trigger = $(By.id(controlId));
        
        trigger.waitUntilClickable().click();
        
        By optionLocator = By.xpath("//div[@role='option' or @role='menuitem' or @role='listbox']//*[contains(text(), '" + optionSearchText + "')] | //div[@role='option' or @role='menuitem' or @role='listbox'][contains(., '" + optionSearchText + "')]");
        
        withTimeoutOf(Duration.ofSeconds(10)).waitFor(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        $(optionLocator).waitUntilClickable().click();
        
        $(optionLocator).waitUntilNotVisible();
    }

    public void selectType(String type) {
        boolean isIncome = type.toLowerCase().contains("income") || type.toLowerCase().contains("ingreso");
        String searchText = isIncome ? "Ingreso" : "Egreso";
        interactWithCustomSelect("Tipo", searchText);
    }

    public void selectTransactionType(String type) {
        selectType(type);
    }

    public void selectCategory(String category) {
        String searchText = category;
        if (category.contains("ó")) searchText = category.substring(0, category.indexOf("ó"));
        if (category.contains("í")) searchText = category.substring(0, category.indexOf("í"));
        
        interactWithCustomSelect("Categ", searchText);
    }

    public void enterDescription(String description) {
        inputDescription.waitUntilClickable().click();
        inputDescription.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        inputDescription.type(description);
    }

    public void enterAmount(String amount) {
        inputAmount.waitUntilClickable().click();
        inputAmount.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        inputAmount.type(amount);
    }

    public void enterDate(String date) {
        evaluateJavascript(
            "arguments[0].value = arguments[1]; " +
            "arguments[0].dispatchEvent(new Event('input', {bubbles: true})); " +
            "arguments[0].dispatchEvent(new Event('change', {bubbles: true}));", 
            inputDate, date
        );
    }

    public void clickSubmit() {
        buttonSubmit.waitUntilClickable().click();
        buttonSubmit.waitUntilNotVisible();
    }

    public void clickSubmitButton() {
        clickSubmit();
    }

    public List<String> getTransactionDescriptions() {
        withTimeoutOf(Duration.ofSeconds(15)).waitFor(ExpectedConditions.presenceOfElementLocated(By.cssSelector("table tbody tr")));
        
        return findAll(By.cssSelector("table tbody tr")).stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }
}
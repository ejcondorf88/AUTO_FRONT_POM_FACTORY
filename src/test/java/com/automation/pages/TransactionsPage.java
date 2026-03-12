package com.automation.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;
import java.util.Random;
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

    @FindBy(xpath = "//button[@type='submit' and contains(., 'Crear')]")
    private WebElementFacade buttonSubmit;

    public void clickNewTransaction() {
        waitForCondition().withTimeout(Duration.ofSeconds(15))
            .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Transacci') or .//*[contains(@class, 'lucide-plus')]]")));

        evaluateJavascript("arguments[0].scrollIntoView({behavior: 'instant', block: 'center'});", buttonOpenModal);
        waitABit(1000);
        buttonOpenModal.click();
        
        $ (By.name("description")).withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible();
        waitABit(2000); 
    }

    private void interactWithCustomSelect(String labelPart, String optionSearchText) {
        WebElementFacade label = $(By.xpath("//label[contains(.,'" + labelPart + "')]"));
        String controlId = label.getAttribute("for");
        WebElementFacade trigger = $(By.id(controlId));
        
        trigger.waitUntilClickable().click();
        
        waitABit(1200); 
        
        By optionLocator = By.xpath("//div[@role='option' or @role='menuitem' or @role='listbox']//*[contains(text(), '" + optionSearchText + "')] | //div[@role='option' or @role='menuitem' or @role='listbox'][contains(., '" + optionSearchText + "')]");
        
        withTimeoutOf(Duration.ofSeconds(8)).waitFor(ExpectedConditions.elementToBeClickable(optionLocator));
        $(optionLocator).click();
        
        waitABit(1000); 
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
        String[] options = {"Alimentación", "Transporte", "Vivienda", "Salud", "Educación", "Entretenimiento", "Otros"};
        String target = "Otros";
        
        if (category != null && !category.isEmpty() && !category.equalsIgnoreCase("random") && !category.equalsIgnoreCase("Others")) {
            target = category;
        } else {
            target = options[new Random().nextInt(options.length)];
        }
        
        String searchText = target;
        if (target.contains("ó")) searchText = target.substring(0, target.indexOf("ó"));
        if (target.contains("í")) searchText = target.substring(0, target.indexOf("í"));
        
        interactWithCustomSelect("Categ", searchText);
    }

    public void enterDescription(String description) {
        WebElementFacade field = $(By.name("description"));
        field.waitUntilClickable().click();
        field.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        field.type(description);
    }

    public void enterAmount(String amount) {
        WebElementFacade field = $(By.name("amount"));
        field.waitUntilClickable().click();
        field.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        field.type(amount);
    }

    public void enterDate(String date) {
        evaluateJavascript(
            "arguments[0].value = arguments[1]; " +
            "arguments[0].dispatchEvent(new Event('input', {bubbles: true})); " +
            "arguments[0].dispatchEvent(new Event('change', {bubbles: true}));", 
            $(By.name("date")), date
        );
    }

    public void clickSubmit() {
        WebElementFacade btn = $(By.xpath("//button[@type='submit' and contains(., 'Crear')]"));
        btn.waitUntilClickable().click();
        
        btn.withTimeoutOf(Duration.ofSeconds(10)).waitUntilNotVisible();
        waitABit(2500); 
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
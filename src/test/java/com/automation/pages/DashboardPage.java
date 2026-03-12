package com.automation.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import java.time.Duration;

public class DashboardPage extends PageObject {

    @FindBy(css = "[data-slot='breadcrumb-page']")
    private WebElementFacade labelDashboard;

    @FindBy(css = "[data-slot='sidebar-trigger']")
    private WebElementFacade buttonSidebarTrigger;

    @FindBy(xpath = "//a[contains(.,'Transacci') or contains(@href,'transactions')]")
    private WebElementFacade linkTransactions;

    @FindBy(css = "[data-slot='avatar']")
    private WebElementFacade avatarUser;

    public String getHeaderText() {
        return labelDashboard.waitUntilVisible().getText();
    }

    public void openSidebar() {
        evaluateJavascript("document.body.style.pointerEvents = 'auto'");
        if (buttonSidebarTrigger.isVisible()) {
            buttonSidebarTrigger.withTimeoutOf(Duration.ofSeconds(5)).waitUntilClickable().click();
            waitForPresenceOf("[data-slot='sidebar-wrapper']");
        }
    }

    public void goToTransactions() {
        openSidebar();
        
        linkTransactions.withTimeoutOf(Duration.ofSeconds(10)).waitUntilClickable().click();
      

        waitForCondition().withTimeout(Duration.ofSeconds(10))
            .until(d -> getDriver().getCurrentUrl().contains("transactions") 
                   || findAll(By.xpath("//h2[contains(.,'Listado') or contains(.,'Transacci')]")).size() > 0);
    }

    public void clickUserDropdown() {
        avatarUser.waitUntilClickable().click();
    }
}
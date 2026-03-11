package com.automation.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends PageObject {

    @FindBy(css = "[data-slot='breadcrumb-page']")
    private WebElement labelDashboard;

    @FindBy(css = "[data-slot='sidebar-trigger']")
    private WebElement buttonSidebarTrigger;

    @FindBy(xpath = "//a[@href='/transactions']")
    private WebElement linkTransactions;

    @FindBy(css = ".oxd-userdropdown-name") // Placeholder from previous, better to use avatar-fallback
    private WebElement dropdownUser;

    @FindBy(xpath = "//span[contains(@class, 'avatar-fallback')]")
    private WebElement avatarUser;

    public DashboardPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public String getHeaderText() {
        return element(labelDashboard).getText();
    }

    public void openSidebar() {
        if (element(buttonSidebarTrigger).isVisible()) {
            element(buttonSidebarTrigger).click();
        }
    }

    public void goToTransactions() {
        element(linkTransactions).click();
    }

    public void clickUserDropdown() {
        element(dropdownUser).click();
    }

    public void clickLogout() {
        element(linkLogout).click();
    }
}

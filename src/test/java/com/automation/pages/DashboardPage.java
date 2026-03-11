package com.automation.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends PageObject {

    @FindBy(css = ".oxd-topbar-header-breadcrumb-module")
    private WebElement labelDashboard;

    @FindBy(css = ".oxd-userdropdown-name")
    private WebElement dropdownUser;

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement linkLogout;

    public DashboardPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public String getHeaderText() {
        return element(labelDashboard).getText();
    }

    public void clickUserDropdown() {
        element(dropdownUser).click();
    }

    public void clickLogout() {
        element(linkLogout).click();
    }
}

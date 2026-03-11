package com.automation.steps;

import com.automation.pages.LoginPage;
import com.automation.pages.DashboardPage;
import net.serenitybdd.annotations.Step;
import org.assertj.core.api.Assertions;

public class LoginSteps {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @Step("Access the application login page")
    public void openLoginPage() {
        loginPage.open();
    }

    @Step("Login with credentials: {0} / {1}")
    public void loginWithCredentials(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Step("Verify that the user is on the dashboard")
    public void verifyDashboardIsDisplayed() {
        Assertions.assertThat(dashboardPage.getHeaderText()).isEqualToIgnoringCase("Dashboard");
    }

    @Step("Perform logout from the application")
    public void logout() {
        dashboardPage.clickUserDropdown();
        dashboardPage.clickLogout();
    }
}

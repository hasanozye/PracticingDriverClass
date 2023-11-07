package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginObjects;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;

public class MyStepdefSO extends BaseSteps {

    LoginObjects differentLogin;
    String usernameX;
    String passwordX;


    @Given("user on {string} page")
    public void userOnPage(String url) {
        differentLogin = new LoginObjects();
        driver.get(url);
    }

    @When("user tries to login with username {string}")
    public void userTriesToLoginWith(String username) {
        click(differentLogin.menuMyAccountLink);
        click(differentLogin.menuLoginLink);
        usernameX = username == null ? "" : username;
        sendKeys(differentLogin.loginFormUsername, usernameX);
    }

    @Then("user tries to login with password {string}")
    public void userTriesToLoginWithPassword(String password) {

        passwordX = password == null ? "" : password;
        sendKeys(differentLogin.loginFormUsername, passwordX);
    }

    @And("login status should be {string}")
    public void userTriesToLoginWithStatus(String status) {
        if (status.equalsIgnoreCase("false")) {

            sendKeys(differentLogin.loginFormUsername, usernameX);
            sendKeys(differentLogin.loginformPassword, passwordX);
            click(differentLogin.loginFormSubmitButton);
            waitForVisibility(differentLogin.loginFailAlertText);
        } else {
            sendKeys(differentLogin.loginFormUsername, usernameX);
            sendKeys(differentLogin.loginformPassword, passwordX);
            click(differentLogin.loginFormSubmitButton);
            waitForVisibility(differentLogin.loginSuccessHeader);
            click(differentLogin.menuMyAccountLink);
            click(differentLogin.menuLogoutLink);
            click(differentLogin.afterLogoutContinueButton);
            click(differentLogin.menuMyAccountLink);
            click(differentLogin.menuLoginLink);
        }

    }
}

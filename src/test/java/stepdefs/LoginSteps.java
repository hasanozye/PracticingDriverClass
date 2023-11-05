package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.LoginObjects;
import readers.property.PropertyReader;

import java.util.List;
import java.util.Map;

import static readers.property.PropertyReader.read;

public class LoginSteps extends BaseSteps {

    LoginObjects loginObjects;

    @Given("user on homepage")
    public void userOnHomepage() {
        loginObjects = new LoginObjects();
        String url = PropertyReader.read().get("url");
        driver.get(url);
    }

    @When("user clicks My Account Link")
    public void userClicksMyAccountLink() {
        click(loginObjects.menuMyAccountLink);
    }

    @And("user clicks Login Link")
    public void userClicksLoginLink() {
        click(loginObjects.menuLoginLink);
    }

    @Then("login page should be visible")
    public void loginPageShouldBeVisible() {
        waitForVisibility(loginObjects.loginFormUsername);
    }

    @When("user fills login form with the following datas")
    public void userFillsLoginFormWithTheFollowingDatas(DataTable table) {
        Map<String, String> data = table.asMap();
        String username = data.get("username") == null ? "" : data.get("username");
        String password = data.get("password") == null ? "" : data.get("password");
        sendKeys(loginObjects.loginFormUsername, username);
        sendKeys(loginObjects.loginformPassword, password);

    }

    @And("user clicks login button")
    public void userClicksLoginButton() {
        click(loginObjects.loginFormSubmitButton);
    }

    @Then("login should be successfull")
    public void loginShouldBeSuccessfull() {
        waitForVisibility(loginObjects.loginSuccessHeader);

    }

    @Then("login should be fail")
    public void loginShouldBeFail() {
        waitForVisibility(loginObjects.loginFailAlertText);

    }

    @When("user search {string}")
    public void userSearch(String text) {
        sendKeys(loginObjects.searchField, text, Keys.ENTER);

    }

    @Then("product count should be {int}")
    public void productCountShouldBe(int num) {
        By searchResult = By.xpath("//h4");
        wait.until(ExpectedConditions.numberOfElementsToBe(searchResult, num));

    }

    @When("user tries to login with list of maps")
    public void userTriesToLoginWithListOfMaps(DataTable table) {

        click(loginObjects.menuMyAccountLink);
        click(loginObjects.menuLoginLink);


        List<Map<String, String>> maps = table.asMaps();
        for (Map<String, String> map : maps) {
            String username = map.get("username") == null ? "" : map.get("username");
            String password = map.get("password") == null ? "" : map.get("password");

            if (map.get("status").equalsIgnoreCase("false")) {

                sendKeys(loginObjects.loginFormUsername, username);
                sendKeys(loginObjects.loginformPassword, password);
                click(loginObjects.loginFormSubmitButton);
                waitForVisibility(loginObjects.loginFailAlertText);
            } else {
                sendKeys(loginObjects.loginFormUsername, username);
                sendKeys(loginObjects.loginformPassword, password);
                click(loginObjects.loginFormSubmitButton);
                waitForVisibility(loginObjects.loginSuccessHeader);
                click(loginObjects.menuMyAccountLink);
                click(loginObjects.menuLogoutLink);
                click(loginObjects.afterLogoutContinueButton);
                click(loginObjects.menuMyAccountLink);
                click(loginObjects.menuLoginLink);
            }


        }


    }
}

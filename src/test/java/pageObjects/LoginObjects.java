package pageObjects;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginObjects {

    public LoginObjects() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@id='top-links']//a[contains(.,'My Account')]")
    public WebElement menuMyAccountLink;

    @FindBy(xpath = "//div[@id='top-links']//a[contains(.,'Login')]")
    public WebElement menuLoginLink;

    @FindBy(xpath = "//a[contains(.,'Continue')]")
    public WebElement afterLogoutContinueButton;

    @FindBy(xpath = "//div[@id='top-links']//a[contains(.,'Logout')]")
    public WebElement menuLogoutLink;

    @FindBy(id = "input-email")
    public WebElement loginFormUsername;

    @FindBy(id = "input-password")
    public WebElement loginformPassword;

    @FindBy(xpath = "//input[@value='Login']")
    public WebElement loginFormSubmitButton;

    @FindBy(xpath = "//h2[contains(.,'My Account')]")
    public WebElement loginSuccessHeader;

    @FindBy(xpath = "//div[contains(@class,'alert-danger')]")
    public WebElement loginFailAlertText;

    @FindBy(xpath = "//input[@name='search']")
    public WebElement searchField;

    @FindBy(tagName = "//h4")
    public WebElement searchResult;


}

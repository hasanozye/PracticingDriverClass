package stepdefs;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseSteps {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BaseSteps() {
        driver = Driver.getDriver();
        wait = Driver.getWait();
    }

    public void click(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        click(element);
    }

    public void click(WebElement element) {
        wait.until(webDriver -> {
            try {
                element.click();
                return true;
            } catch (Exception e1) {
                try {
                    new Actions(webDriver)
                            .moveToElement(element)
                            .click()
                            .perform();
                    return true;
                } catch (Exception e2) {
                    try {
                        ((JavascriptExecutor) webDriver).executeAsyncScript("arguments[0].click()", element);
                        return true;
                    } catch (Exception e3) {
                        return false;
                    }
                }
            }
        });
    }

    public void sendKeys(By locator, CharSequence... text) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        sendKeys(element, text);
    }

    public void sendKeys(WebElement element, CharSequence... text) {
        wait.until(webDriver -> {
            try {
                element.clear();
                element.sendKeys(text);
                return true;
            } catch (Exception e1) {
                try {
                    element.clear();
                    new Actions(webDriver).moveToElement(element).sendKeys(text).perform();
                    return true;
                } catch (Exception e2) {
                    try {
                        element.clear();
                        ((JavascriptExecutor) webDriver).executeAsyncScript("arguments[0].value'" + text + "'", element);
                        return true;
                    } catch (Exception e3) {
                        return false;
                    }
                }
            }
        });
    }

    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }


}

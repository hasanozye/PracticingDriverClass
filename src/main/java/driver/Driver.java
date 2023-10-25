package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static driver.DriverFactory.*;

public class Driver {

    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    private static ThreadLocal<WebDriverWait> waits = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return getDriver(Browsers.CHROME);
    }

    public static WebDriver getDriver(Browsers browser) {
        if (drivers.get() == null) {
            switch (browser) {
                case IE -> {
                    drivers.set(createIe());
                }
                case EDGE -> {
                    drivers.set(createEdge());
                }
                case SAFARI -> {
                    drivers.set(createSafari());
                }
                case FIREFOX -> {
                    drivers.set(createFirefox());
                }
                default -> {
                    drivers.set(createChrome());
                }
            }

        }
        return drivers.get();
    }

}

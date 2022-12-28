package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class LocalDriverManager {

    // to make this work just pass the browser name, that must match from the DriverManagerType class
    public WebDriver createInstance(String browser, BrowserType browserType, String host) throws MalformedURLException {
        String path = "http://" + host + ":4444/wd/hub";
        WebDriver driver = null;


        DriverManagerType driverManagerType = DriverManagerType.valueOf(browser.toUpperCase());
        //  Class<?> driverClass = Class.forName(driverManagerType.browserClass());

        if (browserType.equals(BrowserType.SELENIUM_GRID)) {
            driver = WebDriverManager.getInstance(driverManagerType).remoteAddress(path).create();

//            if (driverManagerType.equals(DriverManagerType.CHROME)) {
//                URL gridUrl = new URL(path);
//                ChromeOptions options = new ChromeOptions();
//                options.setCapability("se:recordVideo", true);
//                options.setCapability("se:timeZone", "US/Pacific");
//                options.setCapability("se:screenResolution", "1920x1080");
//                RemoteWebDriver webDriver = new RemoteWebDriver(gridUrl, options);
//                return webDriver;
//            }
        } else if (browserType.equals(BrowserType.LOCAL)) {
            driver = WebDriverManager.getInstance(driverManagerType).create();
        }

        //driver = (WebDriver) driverClass.newInstance();
        return driver;
    }

    enum BrowserType {
        LOCAL, SELENIUM_GRID
    }
}

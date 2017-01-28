package com.mlyamin.ozon.testing.utils.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

    private WebDriver driver;
    private static WebDriverFactory instance;

    private WebDriverFactory() {
    }

    public static synchronized WebDriverFactory getInstance() {
        if (instance == null) {
            instance = new WebDriverFactory();
        }
        return instance;
    }

    public WebDriver initDriver(Browsers browser) {
        WebDriver driverKeeper;

        switch (browser) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeWebDriver\\chromedriver.exe");
                driverKeeper = new ChromeDriver();
                break;
            default: throw new RuntimeException("Not implemented yet");
        }

        driverKeeper.manage().deleteAllCookies();
        driverKeeper.manage().window().maximize();

        this.driver = driverKeeper;
        return driverKeeper;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            throw new RuntimeException("Init driver first");
        }

        return this.driver;
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

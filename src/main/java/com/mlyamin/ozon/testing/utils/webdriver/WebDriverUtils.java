package com.mlyamin.ozon.testing.utils.webdriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {

    public static void waitForPageToLoad(WebDriver driver) {
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    public static void waitSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            // do nothing
        }
    }
}
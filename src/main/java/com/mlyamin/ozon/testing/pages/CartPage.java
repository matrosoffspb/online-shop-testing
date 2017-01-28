package com.mlyamin.ozon.testing.pages;

import com.mlyamin.ozon.testing.utils.webdriver.WebDriverFactory;
import com.mlyamin.ozon.testing.utils.webdriver.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by mnlya on 28.01.2017.
 */
public class CartPage {

    private WebDriver getDriver() {
        return WebDriverFactory.getInstance().getDriver();
    }

    private String resultPriceXpath = ".//div[contains(@class, 'bCartTotal')]//span[@class = 'eOzonPrice_main']";

    public int getResultPrice() {
        WebDriverUtils.waitSeconds(2);

        String resultPriceAsString = getDriver().findElement(By.xpath(resultPriceXpath)).getText();
        resultPriceAsString = resultPriceAsString.replace(" ", "");
        return Integer.valueOf(resultPriceAsString);
    }
}

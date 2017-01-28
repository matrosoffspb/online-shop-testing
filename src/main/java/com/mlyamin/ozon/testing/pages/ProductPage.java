package com.mlyamin.ozon.testing.pages;

import com.mlyamin.ozon.testing.utils.webdriver.WebDriverFactory;
import com.mlyamin.ozon.testing.utils.webdriver.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by mnlya on 28.01.2017.
 */
public class ProductPage {

    private WebDriver getDriver() {
        return WebDriverFactory.getInstance().getDriver();
    }

    private String addToCardXpath = ".//div[text() = 'Добавить в корзину']";
    private String addOneMoreXpath = ".//div[contains(@class, 'mPlusOne')]";
    private String priceXpath = ".//div[@class = 'bSaleBlock']//span[@class = 'eOzonPrice_main']";

    public int getPrice() {
        WebDriverUtils.waitSeconds(2);

        String priceAsString = getDriver().findElement(By.xpath(priceXpath)).getText();
        priceAsString = priceAsString.replace(" ", "");
        return Integer.valueOf(priceAsString);
    }

    public void addToCart(int count) {
        getDriver().findElement(By.xpath(addToCardXpath)).click();
        WebElement addOneMore = getDriver().findElement(By.xpath(addOneMoreXpath));

        for (int i=1; i <= count-1; i++) {
            addOneMore.click();
        }
    }
}

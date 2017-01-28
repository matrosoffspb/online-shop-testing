package com.mlyamin.ozon.testing.pages;

import com.mlyamin.ozon.testing.utils.webdriver.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by mnlya on 28.01.2017.
 */
public class PersonalCabinetPage {

    private WebDriver getDriver() {
        return WebDriverFactory.getInstance().getDriver();
    }

    private String mainCatalogXpath = ".//span[text() = 'Каталог товаров']";
    private String categoryTemplateXpath = ".//div[contains(@class, 'bMainMenu')]//span[text() = '%s']";

    public CategoryPage clickOnCategory(String categoryName) {
        getDriver().findElement(By.xpath(mainCatalogXpath)).click();

        getDriver().findElement(By.xpath(String.format(categoryTemplateXpath, categoryName))).click();

        return new CategoryPage();
    }
}

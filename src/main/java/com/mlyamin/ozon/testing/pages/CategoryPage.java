package com.mlyamin.ozon.testing.pages;

import com.mlyamin.ozon.testing.utils.webdriver.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by mnlya on 28.01.2017.
 */
public class CategoryPage {

    private WebDriver getDriver() {
        return WebDriverFactory.getInstance().getDriver();
    }

    private String subCategoryXpath = ".//div[contains(@class, 'bLeftMainMenu')]//a[text() = '%s']";

    public SubCategoryPage clickOnSubCategory(String subCategoryName) {
        getDriver().findElement(By.xpath(String.format(subCategoryXpath, subCategoryName))).click();

        return new SubCategoryPage();
    }
}

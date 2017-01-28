package com.mlyamin.ozon.testing.pages;

import com.mlyamin.ozon.testing.utils.webdriver.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubCategoryPage {

    private WebDriver getDriver() {
        return WebDriverFactory.getInstance().getDriver();
    }

    private String brandXpath = ".//div[@id = 'facetControl_brand']//a[contains(text(), 'Lenovo')]";

    private String searchResultTemplateXpath = ".//div[@id = 'PageContainer']//div[@class = 'eOneTile_ItemName' and text() = ' %s ']";

    public SubCategoryPage clickOnBrand() {
        getDriver().findElement(By.xpath(brandXpath)).click();

        return this;
    }

    public ProductPage clickOnProduct(String name) {
        getDriver().findElement(By.xpath(String.format(searchResultTemplateXpath, name))).click();

        return new ProductPage();
    }

}
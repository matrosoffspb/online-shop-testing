package com.mlyamin.ozon.testing.pages;

import com.mlyamin.ozon.testing.utils.webdriver.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private WebDriver getDriver() {
        return WebDriverFactory.getInstance().getDriver();
    }

    private String ozonTabXpath = ".//span[@class = 'ePanelLinks_Label' and text() = 'Мой OZON']";
    private String cartButtonXpath = ".//div[@class = 'mCart']";

    public static MainPage open() throws Exception {
        WebDriverFactory.getInstance().getDriver().get("https://www.ozon.ru/");
        return new MainPage();
    }

    public LoginPage goToLoginPage() {
        WebElement tabElement = getDriver().findElement(By.xpath(ozonTabXpath));

        tabElement.click();
        tabElement.findElement(By.xpath("//*[contains(text(), 'Личный кабинет')]")).click();
        return new LoginPage();
    }

    public CartPage goToCartPage() {
        getDriver().findElement(By.xpath(cartButtonXpath)).click();

        return new CartPage();
    }
}
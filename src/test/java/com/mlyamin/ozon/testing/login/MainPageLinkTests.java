package com.mlyamin.ozon.testing.login;

import com.mlyamin.ozon.testing.pages.*;
import com.mlyamin.ozon.testing.utils.webdriver.Browsers;
import com.mlyamin.ozon.testing.utils.webdriver.WebDriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainPageLinkTests {

    @Before
    public void before() {
        WebDriverFactory.getInstance().initDriver(Browsers.CHROME);
    }

    @After
    public void after() {
        WebDriverFactory.getInstance().closeDriver();
    }

    @Test
    public void licenseLinkTest() throws Exception {

        int amount = 2;

        LoginPage loginPage = MainPage.open().goToLoginPage();

        PersonalCabinetPage personalCabinetPage = loginPage.authorize("mnlyamin@mail.ru", "qwerty12345");

        CategoryPage categoryPage = personalCabinetPage.clickOnCategory("Электроника");

        SubCategoryPage subCategoryPage = categoryPage.clickOnSubCategory("Планшеты");

        subCategoryPage.clickOnBrand();

        ProductPage lenovoPage = subCategoryPage.clickOnProduct("Lenovo Tab 3 (TB3-730X)");
        int lenovoPrice = lenovoPage.getPrice();
        lenovoPage.addToCart(amount);

        CartPage cartPage = MainPage.open().goToCartPage();

        int resultPrice = cartPage.getResultPrice();

        Assert.assertEquals("Prices are not equals", lenovoPrice * amount, resultPrice);

        Thread.sleep(2000);


    }

}

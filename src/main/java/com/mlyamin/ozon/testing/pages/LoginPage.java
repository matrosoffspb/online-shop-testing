package com.mlyamin.ozon.testing.pages;

import com.mlyamin.ozon.testing.utils.webdriver.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by mnlya on 28.01.2017.
 */
public class LoginPage {

    private WebDriver getDriver() {
        return WebDriverFactory.getInstance().getDriver();
    }

    private String loginFieldId = "Login";
    private String passwordFieldId = "Passw";
    private String agreementCheckboxId = "CapabilityAgree";
    private String authenticationButtonId = "Authentication";

    public PersonalCabinetPage authorize(String login, String password) {
        getDriver().findElement(By.id(loginFieldId)).sendKeys(login);
        getDriver().findElement(By.id(passwordFieldId)).sendKeys(password);

//        getDriver().findElement(By.id(agreementCheckboxId)).click();

        getDriver().findElement(By.id(authenticationButtonId)).click();

        return new PersonalCabinetPage();
    }
}

package com.max;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class UITest extends AbstractTest {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static String urlBase = "https://gb.ru/login";


    @BeforeEach
    void openWin() {
        driver = new ChromeDriver(getOptions());
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));

    }

    @Test
    void testGBNotEmailLogin() {
        driver.get(urlBase);

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login("login", "password");
        String textParsley = loginPage.getTextParsleyLogin();
        Assertions.assertFalse(textParsley.isEmpty());
    }

    @Test
    void testGBWithoutPassword() {
        driver.get(urlBase);

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login("login@login.ru", "");
        String textParsley = loginPage.getTextParsleyPassword();
        Assertions.assertFalse(textParsley.isEmpty());
    }

    @AfterEach
    void closeWin() {
        driver.quit();
    }

}
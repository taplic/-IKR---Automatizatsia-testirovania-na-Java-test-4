package com.max;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class UITest {

    @Test
    void testGBNotEmailLogin() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://gb.ru/login");

        driver.findElement(By.xpath("/html/body/div[2]/div[7]/div/form/div[1]/input")).sendKeys("login");
        driver.findElement(By.xpath("/html/body/div[2]/div[7]/div/form/div[2]/input")).sendKeys("password");
        driver.findElement(By.xpath("/html/body/div[2]/div[7]/div/form/div[4]/input")).click();

        Assertions.assertFalse(driver.findElements(By.xpath("/html/body/div[2]/div[7]/div/form/div[1]/ul")).isEmpty());
    }

    @Test
    void testGBWithoutPassword() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://gb.ru/login");
        driver.findElement(By.xpath("/html/body/div[2]/div[7]/div/form/div[1]/input")).sendKeys("login@login.ru");
        driver.findElement(By.xpath("/html/body/div[2]/div[7]/div/form/div[4]/input")).click();

        Assertions.assertFalse(driver.findElements(By.xpath("/html/body/div[2]/div[7]/div/form/div[2]/ul")).isEmpty());

    }

}

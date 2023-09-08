package com.max;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css ="form#new_user input[type='email']")
    private WebElement loginField;

    @FindBy(css = "form#new_user input[type='password']")
    private WebElement passwordField;

    @FindBy(css = "form#new_user input[type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@type='email']/following::li")
    private WebElement parsleyErrorLogin;

    @FindBy(xpath = "//input[@type='password']/following::li")
    private WebElement parsleyErrorPassword;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    void login(String login, String password) {
        wait.until(ExpectedConditions.visibilityOf(loginField)).sendKeys(login);
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOf(loginButton)).click();

    }

    public String getTextParsleyLogin() {
        return wait.until(ExpectedConditions.visibilityOf(parsleyErrorLogin)).getText();
    }

    public String getTextParsleyPassword() {
        return wait.until(ExpectedConditions.visibilityOf(parsleyErrorPassword)).getText();
    }
}
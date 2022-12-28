package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private final String URL_LINK = "https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html#";
    private WebDriver driver;
    private WebDriverWait webDriverWait;
    @FindBy(name = "firstName")
    private WebElement firstNameTxt;

    @FindBy(name = "lastName")
    private WebElement lastNameTxt;

    @FindBy(id = "email")
    private WebElement userNameTxt;

    @FindBy(name = "password")
    private WebElement passwordTxt;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(name = "register")
    private WebElement submitBtn;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        this.driver.get(URL_LINK);
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(this.firstNameTxt));
    }

    public void addUserDetails(String firstName, String lastName) {
        this.firstNameTxt.sendKeys(firstName);
        this.lastNameTxt.sendKeys(lastName);
    }

    public void addUserCredentials(String userName, String password, String confirmPassword) {
        userNameTxt.sendKeys(userName);
        passwordTxt.sendKeys(password);
        confirmPasswordTxt.sendKeys(confirmPassword);
    }

    public void submitRegistrationPage() {
        submitBtn.click();
    }
}


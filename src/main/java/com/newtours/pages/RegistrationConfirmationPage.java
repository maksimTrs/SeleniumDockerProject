package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationConfirmationPage {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    @FindBy(partialLinkText = "sign-in")
    private WebElement signInLink;

    @FindBy(linkText = "Flights")
    private WebElement flightsLink;


    public RegistrationConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public void goToFlightDetailsPage() {
        this.webDriverWait.until(ExpectedConditions.visibilityOf(signInLink));
        this.flightsLink.click();
    }
}


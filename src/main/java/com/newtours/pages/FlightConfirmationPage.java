package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FlightConfirmationPage {
//table[@id="confirm-table"]//td[text()='Total Price']/following::font
//table[@id="confirm-table"]//td[text()='Total Price']


    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//font[contains(text(), 'Confirmation')]")
    private WebElement flightConfirmationHeader;

    @FindBy(xpath = "//font[contains(text(), 'USD')]")
    private List<WebElement> prices;

    @FindBy(linkText = "SIGN-OFF")
    private WebElement signOffLink;

    public FlightConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public int getPrice() {
        this.wait.until(ExpectedConditions.visibilityOf(this.flightConfirmationHeader));
        System.out.println(this.flightConfirmationHeader.getText());
        System.out.println(this.prices.get(1).getText());
        String price = this.prices.get(1).getText();

        StringBuilder stringBuilder = new StringBuilder(price);
        int spaceIndex = stringBuilder.indexOf(" ");
        String priceValue = stringBuilder.substring(1, spaceIndex);
        //System.out.println(priceValue);

        this.signOffLink.click();

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        return Integer.parseInt(priceValue);
    }


}


package com.searchmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage {
    private final String URL = "https://duckduckgo.com/";
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(name = "q")
    private WebElement searchTxt;

    @FindBy(id = "search_button_homepage")
    private WebElement searchBtn;

    @FindBy(xpath = "//a[@data-zci-link='videos']")
    private WebElement videosLink;

    //  @FindBy(className = "tile--vid")
    @FindBy(xpath = "//h6")
    private List<WebElement> allVideos;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        this.driver.get(URL);
    }

    public void doSearch(String keyword) {
        this.wait.until(ExpectedConditions.visibilityOf(this.searchTxt));
        this.searchTxt.sendKeys(keyword);
        this.searchBtn.click();
    }

    public void goToVideos() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.videosLink));
        this.videosLink.click();
    }

    //synchronized
    public int getResult() {
        By by = By.className("tile--vid");
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 5));
        // synchronized (allVideos) {
        System.out.println(">>>>>  Search Count Result: " + allVideos.size() + "  <<<<<");
        //   }

        allVideos//.parallelStream()
                .stream()
                .map(WebElement::getText)
                .forEach(ss -> System.out.println("Video Header = " + "< " + ss + " >"));

        return this.allVideos.size();
    }

}

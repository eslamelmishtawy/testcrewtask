package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubscriptionPage {
    private final WebDriver driver;
    private final By countryButton = By.id("country-btn");
    private final By litePlanText = By.id("name-lite");
    private final By classicPlanText = By.id("name-classic");
    private final By premiumPlanText = By.id("name-premium");
    private final By liteCurrency = By.id("currency-lite");
    private final By classicCurrency = By.id("currency-classic");
    private final By premiumCurrency = By.id("currency-premium");

    private final By languageButton = By.id("translation-btn");

    public SubscriptionPage(WebDriver driver){
        this.driver = driver;
    }

    public String getSubscriptionPackagePageTitle(){
        return driver.getTitle();
    }
    public Boolean litePlanDetailsIsDisplayed(){
        Boolean litePlanTextStatus = driver.findElement(litePlanText).isDisplayed();
        Boolean litePlanCurrencyStatus = driver.findElement(liteCurrency).isDisplayed();
        return (litePlanTextStatus && litePlanCurrencyStatus);
    }
    public Boolean classicPlanDetailsIsDisplayed(){
        Boolean classicPlanTextStatus = driver.findElement(classicPlanText).isDisplayed();
        Boolean classicPlanCurrencyStatus = driver.findElement(classicCurrency).isDisplayed();
        return (classicPlanTextStatus && classicPlanCurrencyStatus);
    }
    public Boolean premiumPlanDetailsIsDisplayed(){
        Boolean premiumPlanTextStatus = driver.findElement(premiumPlanText).isDisplayed();
        Boolean premiumPlanCurrencyStatus = driver.findElement(premiumCurrency).isDisplayed();
        return (premiumPlanTextStatus && premiumPlanCurrencyStatus);
    }
    public void clickOnCountryButton(){
        driver.findElement(countryButton).click();
    }
    public String getCountryDisplayed(){
        return (driver.findElement(countryButton).getText());
    }
    public String getLanguageDisplayed(){
        return (driver.findElement(languageButton).getText());
    }
    public String getLitePlanPrice(){
        return (driver.findElement(liteCurrency).getText());
    }
    public String getClassicPlanPrice(){
        return (driver.findElement(classicCurrency).getText());
    }
    public String getPremiumPlanPrice(){
        return (driver.findElement(premiumCurrency).getText());
    }

}

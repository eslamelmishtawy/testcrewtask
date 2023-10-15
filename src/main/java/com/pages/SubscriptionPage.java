package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.utils.*;


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
        Boolean litePlanTextStatus = Utils.elementIsDisplayed(driver, Constants.waitTime, litePlanText);
        Boolean litePlanCurrencyStatus = Utils.elementIsDisplayed(driver, Constants.waitTime, liteCurrency);
        return (litePlanTextStatus && litePlanCurrencyStatus);
    }
    public Boolean classicPlanDetailsIsDisplayed(){
        Boolean classicPlanTextStatus = Utils.elementIsDisplayed(driver, Constants.waitTime, classicPlanText);
        Boolean classicPlanCurrencyStatus = Utils.elementIsDisplayed(driver, Constants.waitTime, classicCurrency);
        return (classicPlanTextStatus && classicPlanCurrencyStatus);
    }
    public Boolean premiumPlanDetailsIsDisplayed(){
        Boolean premiumPlanTextStatus = Utils.elementIsDisplayed(driver, Constants.waitTime, premiumPlanText);
        Boolean premiumPlanCurrencyStatus = Utils.elementIsDisplayed(driver, Constants.waitTime, premiumCurrency);
        return (premiumPlanTextStatus && premiumPlanCurrencyStatus);
    }
    public void clickOnCountryButton(){
        Utils.clickOnElement(driver, Constants.waitTime, countryButton);

    }
    public String getCountryDisplayed(){
        return (Utils.getText(driver,Constants.waitTime, countryButton));
    }
    public String getLanguageDisplayed(){
        return (Utils.getText(driver,Constants.waitTime, languageButton));
    }
    public String getLitePlanPrice(){
        return (Utils.getText(driver,Constants.waitTime, liteCurrency));
    }
    public String getClassicPlanPrice(){
        return (Utils.getText(driver,Constants.waitTime, classicCurrency));
    }
    public String getPremiumPlanPrice(){
        return (Utils.getText(driver,Constants.waitTime, premiumCurrency));
    }

    public void selectArabicLanguage(){
        Utils.clickOnElement(driver, Constants.waitTime, languageButton);
    }

}

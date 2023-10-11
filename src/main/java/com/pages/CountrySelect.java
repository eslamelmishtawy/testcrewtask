package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CountrySelect {
    private final WebDriver driver;
    private final By sa_country_flag = By.id("sa");
    private final By bh_country_flag = By.id("bh");
    private final By kw_country_flag = By.id("kw");

    public CountrySelect(WebDriver driver){
        this.driver = driver;
    }
    public void clickOnCountryFlag(String s){
        if (s.equals("KSA")){
            driver.findElement(sa_country_flag).click();
        } else if (s.equals("Kuwait")) {
            driver.findElement(kw_country_flag).click();
        } else if (s.equals("Bahrain")) {
            driver.findElement(bh_country_flag).click();
        } else {
            System.out.println("Country provided is not in the list");
        }
    }
}

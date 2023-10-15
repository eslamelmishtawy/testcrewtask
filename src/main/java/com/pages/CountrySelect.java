package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.utils.*;

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
            Utils.clickOnElement(driver, Constants.waitTime, sa_country_flag);
        } else if (s.equals("Kuwait")) {
            Utils.clickOnElement(driver, Constants.waitTime, kw_country_flag);
        } else if (s.equals("Bahrain")) {
            Utils.clickOnElement(driver, Constants.waitTime, bh_country_flag);
        } else {
            System.out.println("Country provided is not in the list");
        }
    }
}

package com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class Utils {
    public static Boolean elementIsDisplayed(WebDriver driver , Duration time , By element){
        Boolean statues;
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        statues = driver.findElement(element).isDisplayed();
        return  statues;
    }

    public  static void clickOnElement(WebDriver driver , Duration time , By element){

        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();

    }
    public static String getText (WebDriver driver,Duration time , By element ){
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return driver.findElement(element).getText();
    }
}

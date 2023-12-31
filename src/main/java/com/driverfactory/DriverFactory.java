package com.driverfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class DriverFactory {
    public WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver init_driver(String browser)
    {
        if(browser.equals("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--start-maximized");
            options.setBrowserVersion("118");
            tlDriver.set(new ChromeDriver(options));

        } else if (browser.equals("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            options.setBrowserVersion("118");
            tlDriver.set(new FirefoxDriver(options));
        } else {
            System.out.println("Please Enter Valid Browser");
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    public static synchronized WebDriver getDriver(){
        return tlDriver.get();
    }

}

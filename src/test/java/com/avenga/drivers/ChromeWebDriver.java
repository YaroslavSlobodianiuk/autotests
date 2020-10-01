package com.avenga.drivers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class ChromeWebDriver implements WebDriver {

    public ChromeDriver driver;

    @Override
    @BeforeClass
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "/Users/Yarik/Downloads/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Override
    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}

package com.avenga;

import com.avenga.drivers.ChromeWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class EnglishDomTest extends ChromeWebDriver {

    @BeforeMethod
    public void openWebSite() {
        driver.get("https://www.englishdom.com/");
    }

    @Test
    public void titleTest() {

        String title = driver.getTitle();
        Assert.assertEquals(title, "Английский по Скайпу — обучение английскому языку по Скайпу в онлайн-школе EnglishDom");
    }

    @Test
    public void shouldOpenRUWebSiteVersion(){
        WebElement webElement = driver.findElement(By.xpath("//div[@class='b-switch']//div[@class='selected-switch js-switch']"));
        Assert.assertEquals(webElement.getText(), "RU");
    }

    @Test
    public void shouldOpenUAWebSiteVersion(){
        driver.get("https://www.englishdom.com/ua");
        WebElement webElement = driver.findElement(By.xpath("//div[@class='b-switch']//div[@class='selected-switch js-switch']"));
        Assert.assertEquals(webElement.getText(), "UA");
    }

    @Test
    public void shouldChangeLanguageToUA() throws InterruptedException {
        driver.findElement(By.cssSelector(".b-switch:nth-child(7) > .selected-switch")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".b-switch:nth-child(7) .item-switch:nth-child(1) > .link-item-switch")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.englishdom.com/ua/");

    }

    @Test
    public void shouldOpenDetails() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElement(By.cssSelector(".learn-effectively-btn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".seo-learn-effectively")));

    }



}

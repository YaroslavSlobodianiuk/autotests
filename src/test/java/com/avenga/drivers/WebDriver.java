package com.avenga.drivers;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public interface WebDriver {

    @BeforeClass
    void openBrowser();

    @AfterClass
    void closeBrowser();
}

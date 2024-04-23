package org.automationTesting.BaseClass;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

/**
 * This Class is a Base class it has the main functionality to run the driver and quite the driver.
 */
public class Base {
    //This String has URL


    protected RemoteWebDriver driver = null;

    String url = "https://www.amazon.in/";

    /**
     * This method will have all the functionality to start the app.
     */
    public void startApp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
    }

    /**
     * This method will quite the driver.
     */
    public void closeApp() {

        driver.quit();
    }


}

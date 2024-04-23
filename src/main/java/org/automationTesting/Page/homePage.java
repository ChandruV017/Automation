package org.automationTesting.Page;

import org.automationTesting.BaseClass.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * This class has the methods and functions to preform following tasks:
 * 1.Checks element is visible
 * 2.enter input(dynamic)
 * 3.Take Screenshot
 */
public class homePage extends Base {


    public homePage(RemoteWebDriver driver) {
        this.driver = driver;

    }

    //Visibility checks
    public boolean amazonLogoVisible() {

        return driver.findElement(By.id("nav-logo-sprites")).isDisplayed();
    }

    public boolean locationVisible() {
        return driver.findElement(By.id("glow-ingress-block")).isDisplayed();
    }

    public boolean searchBoxVisible() {
        return driver.findElement(By.id("twotabsearchtextbox")).isDisplayed();
    }

    public boolean languageChangeVisible() {
        return driver.findElement(By.id("icp-nav-flyout")).isDisplayed();
    }

    public boolean accountSigninVisible() {
        return driver.findElement(By.id("nav-link-accountList")).isDisplayed();
    }

    public boolean returnOrOrderVisible() {
        return driver.findElement(By.id("nav-orders")).isDisplayed();
    }

    public boolean cartVisible() {
        return driver.findElement(By.id("nav-cart")).isDisplayed();
    }

    //actions

    /**
     * This method will search the product and it will add to cart.
     *
     * @param Pname
     * @throws IOException
     * @throws InterruptedException
     */
    public void addtocartperform(String Pname) throws IOException, InterruptedException {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Pname, Keys.ENTER);

        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
        Thread.sleep(3000);
        //windowHandling
        Set<String> windows = driver.getWindowHandles();

        List<String> winList = new ArrayList<>(windows);
        driver.switchTo().window(winList.get(1));
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]")).click();
        driver.navigate().refresh();

        driver.findElement(By.id("nav-cart")).click();

        /*
        WebElement cart = driver.findElement(By.id("sc-active-cart"));

        //This Performs taking ScreenShots
        File cartIMG = cart.getScreenshotAs(OutputType.FILE);
        File FilePath = new File("./imgs/CartScreenShot2.png");
        FileHandler.copy(cartIMG, FilePath);    */


    }


    public void screenshot(String name) throws IOException {
        WebElement cart = driver.findElement(By.id("sc-active-cart"));

        //This Performs taking ScreenShots
        File cartIMG = cart.getScreenshotAs(OutputType.FILE);
        File FilePath = new File("./imgs/" + name + ".png");
        FileHandler.copy(cartIMG, FilePath);
    }

}

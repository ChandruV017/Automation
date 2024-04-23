package org.automationTesting.Testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.automationTesting.BaseClass.Base;
import org.automationTesting.Page.homePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * This is the Test Class and also this has a methods to save the Extent Report for external use.
 *
 */
public class TC002 extends Base {

    /**
     * This is the Test method with Test annotation which runs on TestNG, and also it generates report.
     * @throws IOException
     * @throws InterruptedException
     */
    @Test
    public void TCOO1() throws IOException, InterruptedException {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./Reports/report4.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        ExtentTest test = extent.createTest("TC0001 - Product Adding To Cart");


        homePage pg = new homePage(driver);

        pg.startApp();
        test.pass("Amazon Page Opened");
        boolean logo = pg.amazonLogoVisible();
        Assert.assertTrue(logo);
        test.pass("Amazon logo is visible");
        boolean location = pg.locationVisible();
        Assert.assertTrue(location);
        test.pass("location visible");
        boolean lang = pg.languageChangeVisible();
        Assert.assertTrue(lang);
        test.pass("language visible");
        boolean acc = pg.accountSigninVisible();
        Assert.assertTrue(acc);
        test.pass("Account visible");
        boolean RandO = pg.returnOrOrderVisible();
        Assert.assertTrue(RandO);
        test.pass("Return and orders option visible");
        boolean cart = pg.cartVisible();
        Assert.assertTrue(cart);
        test.pass("cart visble");


        boolean search = pg.searchBoxVisible();
        Assert.assertTrue(search);
        test.pass("Search Box is Visible");

        pg.addtocartperform("apple");
        test.pass("Product added to cart");

        pg.screenshot("apple2");

        pg.closeApp();
        test.pass("browser closed successfully");

        extent.flush();
    }


}

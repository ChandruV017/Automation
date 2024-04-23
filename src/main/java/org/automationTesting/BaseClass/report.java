package org.automationTesting.BaseClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.*;

public class report {
    ExtentReports extent;
    ExtentTest test;


    @BeforeSuite
   protected void reportGenerate(String TestCaseName) {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./Reports/report1.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);


        ExtentTest test = extent.createTest(TestCaseName);
    }
@AfterSuite
    protected void saveReporte() {
        extent.flush();
    }

   /* @BeforeClass
    void creatTestCase(String name, String Author) {
        test = extent.createTest(name);
        test.assignAuthor(Author);

    }*/

    /*void reportStatus(String status, String description) {
        switch (status.toLowerCase()) {
            case "pass":
                test.pass(description);
            case "fail":
                test.fail(description);
            case "info":
                test.info(description);
            case "warning":
                test.warning(description);
            default:
                System.err.println("Status Not Defined");
                break;
        }*/


    }


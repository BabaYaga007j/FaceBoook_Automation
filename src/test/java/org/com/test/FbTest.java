package org.com.test;

import org.com.fb.driver.DriverSetup;
import org.com.fb.operations.CreateAccountUtils;
import org.com.fb.operations.LogInUtils;
import org.com.fb.utility.ScreenshotUtil;
import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
/**
 * Author: Soumya Sourav Behera
 * Date: June 30, 2023
 */
public class FbTest {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverSetup.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        DriverSetup.closeDriver();
    }
    private void maximizeWindow() {
        driver.manage().window().maximize();
    }

    private void navigateToFacebook() {
        driver.get("https://www.facebook.com/");
        maximizeWindow();
    }
    @Test(priority = 1)
    public void methods() throws InterruptedException {

        navigateToFacebook();

        String title = driver.getTitle();
        System.out.println("Title of the page " + title);

        String currUrl = driver.getCurrentUrl();
        System.out.println("Current title of the page " + currUrl);

        String pageSource = driver.getPageSource();
        System.out.println("the source code of the page is :" + pageSource);

        Thread.sleep(2000);

        driver.close();
    }
    @Test(priority = 2)
    public void navigation()
    {
        navigateToFacebook();
        driver.navigate().to("https://www.google.com");

        driver.navigate().refresh();
        driver.navigate().back();
        driver.navigate().forward();
    }
    @Test(priority = 3)
    public void takeScreeShots() throws IOException, InterruptedException
    {
        navigateToFacebook();

        ScreenshotUtil screenshotUtil = new ScreenshotUtil(driver);
        screenshotUtil.takeScreenshot();

        Thread.sleep(2000);

        driver.close();
    }

    @Test(priority = 4)
    public void Login() throws InterruptedException {

        LogInUtils loginUtil = new LogInUtils(driver);
        loginUtil.login("abcd@12345", "123123");

    }
    @Test(priority = 5)
    public void createAccount() throws InterruptedException {

        CreateAccountUtils createAccountUtil = new CreateAccountUtils(driver);
        createAccountUtil.createAccount("Baba", "Yaga", "0000000000", "Abcd123", "7", "May", "1996");

    }

}

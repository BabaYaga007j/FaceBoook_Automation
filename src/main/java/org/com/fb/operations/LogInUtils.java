package org.com.fb.operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Author: Soumya Sourav Behera
 * Date: June 30, 2023
 */
public class LogInUtils {

    private WebDriver driver;

    public LogInUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) throws InterruptedException {
        navigateToFacebook();

        driver.findElement(By.id("email")).sendKeys(email);
        Thread.sleep(2000);
        driver.findElement(By.id("pass")).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.name("login")).submit();
        Thread.sleep(2000);
    }

    private void navigateToFacebook() {
        driver.get("https://www.facebook.com/");
        maximizeWindow();
    }

    private void maximizeWindow() {
        driver.manage().window().maximize();
    }
}

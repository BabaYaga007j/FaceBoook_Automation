package org.com.fb.operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * Author: Soumya Sourav Behera
 * Date: June 30, 2023
 */
public class CreateAccountUtils {

    private WebDriver driver;

    public CreateAccountUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void createAccount(String firstName, String lastName, String email, String password, String day, String month, String year) throws InterruptedException {
        navigateToFacebook();

        driver.findElement(By.linkText("Create new account")).click();
        Thread.sleep(2000);

        driver.findElement(By.name("firstname")).sendKeys(firstName);
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        driver.findElement(By.name("reg_email__")).sendKeys(email);
        driver.findElement(By.name("reg_passwd__")).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.id("day")).sendKeys(day);
        Thread.sleep(2000);
        driver.findElement(By.id("month")).sendKeys(month);
        Thread.sleep(2000);
        driver.findElement(By.id("year")).sendKeys(year);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[text()='Male']")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("websubmit")).click();
    }

    private void navigateToFacebook() {
        driver.get("https://www.facebook.com/");
        maximizeWindow();
    }

    private void maximizeWindow() {
        driver.manage().window().maximize();
    }
}

package com_utimateqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Check on Multi Browser
 */
public class MultiBrowser {
    static String browser = "Chrome";
    static String baseUrl = "https://courses.ultimateqa.com/";
    String homePage = "https://courses.ultimateqa.com/collections";
    static WebDriver driver;

    public static void main(String[] args) {
        //1 Drivers created for chrome setup
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }
        // 2 Open Url
        driver.get(baseUrl);
        // Maximise the browser
        driver.manage().window().maximize();
        // Implicit wait to the driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // 3 Print the Title of the page
        System.out.println("Print the tile of the page : " + driver.getTitle());
        // 4 Print the current Url
        System.out.println("The current Url : " + driver.getCurrentUrl());
        // 5 Print the page source
        System.out.println("The page source : " + driver.getPageSource());
        // 6 Click on 'Sign In' link
        driver.findElement(By.linkText("Sign In")).click();
        // 7 Print the current Url
        System.out.println("The current Url : " + driver.getCurrentUrl());
        // 8 Enter the email to email field
        driver.findElement(By.id("user[email]")).sendKeys("prime123@gmail.com");
        // 9 Enter the password to password field
        driver.findElement(By.id("user[password]")).sendKeys("prime123");
        // 10 Click on Login Button
        driver.findElement(By.cssSelector(".button")).click();
        // 11 Navigate to baseUrl
        driver.navigate().back();
        // 12 Navigate forward to Homepage
        String homePage = "https://courses.ultimateqa.com/collections";
        driver.navigate().to(homePage);
        // 13 Navigate back to baseUrl
        driver.navigate().back();
        // 14 Refresh the page
        driver.navigate().refresh();
        // 15 Close the browser
        driver.quit();
    }
}

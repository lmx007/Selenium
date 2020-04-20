package com.testing02.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class idSelectTest {

    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\Selenium_Dome01\\.idea\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void closeChrome(){
        //   完全退出浏览器
        driver.quit();
    }

    @Test
    public void idSelect() throws InterruptedException {
        driver.get("http://news.baidu.com/");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"change-city\"]"));
        element.click();
        Thread.sleep(5000);
        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"city_view\"]/div[1]/a[2]"));
        // 点击
        element1.click();
        Thread.sleep(5000);
        Boolean b = element.isSelected();
        Assert.assertTrue(b);


    }

}

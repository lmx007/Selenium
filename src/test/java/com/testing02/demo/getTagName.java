package com.testing02.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class getTagName {

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
    public void getTagName(){
        // 打开百度首页
        driver.get("https://www.baidu.com/");
        String tagName = driver.findElement(By.id("kw")).getTagName();
        Assert.assertEquals(tagName,"input");

    }
}

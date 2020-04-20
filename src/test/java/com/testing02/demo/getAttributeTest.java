package com.testing02.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class getAttributeTest {

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
    public void getATest(){
        // 打开百度首页
        driver.get("https://www.baidu.com/");
        // 定位 搜索框
        String att = driver.findElement(By.id("su")).getAttribute("value");
        // 获取tagName 并输出
        Assert.assertEquals(att,"百度一下");

    }
}

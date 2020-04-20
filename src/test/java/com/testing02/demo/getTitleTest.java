package com.testing02.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class getTitleTest {

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
    public void getATest() {
        // 打开百度首页
        driver.get("https://www.baidu.com/");
        // 获取百度首页的title
        String title = driver.getTitle();
        // 校验title值等于"百度一下，你就知道"
        Assert.assertEquals(title,"百度一下，你就知道");
    }
}

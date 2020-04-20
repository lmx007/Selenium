package com.testing02.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class clickTest {
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
    public void clickTest() throws InterruptedException {
        driver.get("http://www.baidu.com/");
        Thread.sleep(3000);
        // 定位新闻连接 ,并点击新闻链接
        WebElement newslink = driver.findElement(By.linkText("新闻"));
        newslink.click();
        Thread.sleep(3000);
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"http://news.baidu.com/");
        Thread.sleep(5000);
    }

}

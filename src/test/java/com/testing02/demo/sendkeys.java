package com.testing02.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class sendkeys {

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
    public void sendkeysTest() throws InterruptedException {
        // 打开百度首页
        driver.get("https://www.baidu.com/");
        // 搜索框输入selenium
        driver.findElement(By.id("kw")).sendKeys("selenium");
        // 点击百度按钮
        driver.findElement(By.id("su")).click();
        Thread.sleep(3000);
        // 获取页面title
        String title = driver.getTitle();
        // 校验
        Assert.assertEquals(title,"selenium_百度搜索");
    }

}

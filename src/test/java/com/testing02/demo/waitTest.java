package com.testing02.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class waitTest {

    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\Selenium_Dome01\\.idea\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //全局等待 放在最外层
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.DAYS);
    }
    @AfterMethod
    public void closeChrome(){
        //   完全退出浏览器
        driver.quit();
    }
    /**
     * 打开测试页面
     * 打开 wait 按钮
     * 获取文本，并判断是否为“wait for display”
     */
    @Test
    public void waitTest(){
        driver.get("");
        driver.findElement(By.xpath("")).click();
        // 显示等待 一般情况都用这个
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));

        String text = driver.findElement(By.xpath("")).getText();
        Assert.assertEquals(text,"wait for display");
    }
}




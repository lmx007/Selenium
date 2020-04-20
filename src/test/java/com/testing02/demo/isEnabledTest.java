package com.testing02.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class isEnabledTest {
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
    /**
     * 打开测试页面
     * 判断 sumbit 按钮处于未激活的状态
     */
    @Test
    public void isEnabled() throws InterruptedException {
        // 打开百度首页
        driver.get("https://www.baidu.com/");
        // 获取百度一下 按钮是否显示
        Boolean bl = driver.findElement(By.id("su")).isEnabled();
        Thread.sleep(3000);
        // 校验结果
        Assert.assertTrue(bl);

    }

}

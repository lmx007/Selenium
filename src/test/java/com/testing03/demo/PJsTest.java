package com.testing03.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

public class PJsTest {
    WebDriver driver;

    @Test
    public void PhantomJsTest() throws InterruptedException {
        // 设置JS的路径 + phantomjs.exe
        System.setProperty("phantomjs.binary.path","D:\\Selenium_Dome01\\.idea\\drivers\\phantomjs.exe");
        // 实例化PhantomJSDriver();
        driver = new PhantomJSDriver();
        Thread.sleep(3000);

        // 打开百度首页
        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).sendKeys("phantomJS");
        Thread.sleep(5000);
        String title = driver.getTitle();
        System.out.println(title);
        Thread.sleep(3000);
        driver.quit();
    }
}

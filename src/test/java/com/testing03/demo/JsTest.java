package com.testing03.demo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JsTest {

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
     * 打开百度页面
     * 执行Js操作
     */
    @Test
    public void exJS() throws InterruptedException {
        // 打开百度首页
        driver.get("https://www.baidu.com/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"webdriver\")");
        Thread.sleep(5000);








    }






}

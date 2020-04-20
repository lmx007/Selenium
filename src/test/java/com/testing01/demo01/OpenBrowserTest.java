package com.testing01.demo01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenBrowserTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        //      设置chrome 浏览器路径
        System.setProperty("webdriver.chrome.driver","D:\\Selenium_Dome01\\.idea\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test  // 打开谷歌浏览器第2种方法
    public void openChrome01() throws InterruptedException {
        //    打开百度网址
        driver.get("https://www.baidu.com");
        //    等待3秒
        Thread.sleep(3000);
        //    获取url
        String url = driver.getCurrentUrl();
        System.out.println(url);
        //    等待5秒
        Assert.assertEquals(url,"https:www.baidu.com/");
        //    等待5秒
        Thread.sleep(5000);
        //   关闭当前浏览器窗口
        driver.close();

    }
    @AfterMethod
    public void closeBrowser(){
        //   完全退出浏览器
        driver.quit();
    }
}


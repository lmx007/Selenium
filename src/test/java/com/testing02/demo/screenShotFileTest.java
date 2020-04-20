package com.testing02.demo;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class screenShotFileTest {
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
     * 打开百度主页
     * 截图
     */
    @Test
    public void ShotFile(){
        // 打开百度首页
        driver.get("https://www.baidu.com/");
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        try{
//            FileUitls.copyFile(file,new File("D:\\jietu.jpg"));
//        } catch (IOException e){
//            e.printStackTrace();
//        }

    }
}

package com.testing03.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest {

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
    public void registerTest() throws InterruptedException {
        //打开163邮箱网页
        driver.get("https://mail.163.com/");
        //先点击切换
        driver.findElement(By.id("lbNormal")).click();
        Thread.sleep(3000);
        //将控制权转交到iframe里面
        driver.switchTo().frame("x-URS-iframe1586256644347.8848");
        // 点击去注册按钮
        driver.findElement(By.id("changepage")).click();
        // 获取当前driver 所在的 handle 值
        String handle1 = driver.getWindowHandle();
        // driver  切换到新的window页面
        for (String handles : driver.getWindowHandles()){
            if(handles.equals(handle1)){
                continue;
            }
            driver.switchTo().window(handles);
        }
        // 相当于随机数
        String time = String.valueOf(System.currentTimeMillis()/100);

        driver.findElement(By.id("username")).sendKeys("email"+ time);
        driver.findElement(By.id("password")).sendKeys("lmx170800");
        driver.findElement(By.id("phone")).sendKeys(time);
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[4]/span")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[5]/a[1]")).click();

        // 显示等待
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));

        String error = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[3]/div[2]")).getText();
        // 校验
        Assert.assertEquals(error,"系统未收到短信，请检查手机号是否正确或重新发送短信");
    }


}

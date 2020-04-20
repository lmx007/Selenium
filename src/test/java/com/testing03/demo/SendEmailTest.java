package com.testing03.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SendEmailTest {

    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\Selenium_Dome01\\.idea\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        // 需要加显示等待
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.163.com/");
    }

    @AfterMethod
    public void closeChrome(){
        //   完全退出浏览器
        driver.quit();
    }

    @Test
    public void sendEmail() throws InterruptedException {

        LoginTest.login(driver,"17080053135","lmx17080053135");
        //  点击 写信按钮
        driver.findElement(By.className("js-component-emailcontainer nui-multiLineIpt C-multiLineIpt nui-ipt")).click();
        driver.findElement(By.className("js-component-emailtips nui-ipt-placeholder")).sendKeys("17080053135@163.com");
        // 定位主题文本框，并输入文本
        driver.findElement(By.xpath("//*[@aria-label=\"邮件主题输入框，请输入邮件主题\"]/input")).sendKeys("这是要发送的邮件");
        // 添加附近，上传图片
        driver.findElement(By.xpath("//*[@title=\"一次可发送2000张照片，600首MP3，一部高清电影\"]/input")).sendKeys("C:\\Users\\hetao\\Desktop\\g3.jpg");

        // 定位iframe   文本内容输入
        WebElement iframe = driver.findElement(By.className("APP-editor-textarea"));
        // 把定位元素转交iframe  用switchto
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("/html/body/p")).sendKeys("你好，这是发给你的文件，需求您签字");
        //  把driver控制权转交回页面
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[text()=\"发送\"]")).click();
        // 校验是否有发送成功字段 , 如果没有 “ 发送成功” 代表没有通过，case失败
        Boolean b = driver.findElement(By.xpath("//*[text()=\"发送成功\"]")).isDisplayed();
        Assert.assertTrue(b);
    }





}

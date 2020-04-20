package com.testing03.demo;

import com.po.page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\Selenium_Dome01\\.idea\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mail.163.com/");
    }

    @AfterMethod
    public void closeChrome(){
        //   完全退出浏览器
        driver.quit();
    }
    @Test
    public void LoginTest() throws InterruptedException {

        LoginTest.login(driver,"17080053135","lmx17080053135");

        // 显示等待
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));

        String logout = driver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(logout,"退出");

    }
    @Test
    public void loginerror() throws InterruptedException {

        LoginTest.login(driver,"17080053135","lmx17080053135");

        // 显示等待
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"nerror\"]/div[2]")));

        String error = driver.findElement(By.xpath("//*[@id=\"nerror\"]/div[2]")).getText();
        Assert.assertEquals(error,"帐号或密码错误      ");

    }

    // 把登录封装起来
    public static void login(WebDriver driver,String email,String pwd) throws InterruptedException {

        //先点击切换
        driver.findElement(LoginPage.qiehuan).click();
        Thread.sleep(3000);
        //将控制权转交到iframe里面
        driver.switchTo().frame("x-URS-iframe1586256644347.8848");
        // 输入邮箱用户名
        driver.findElement(LoginPage.emailInput).sendKeys(email);
        // 输入密码
        driver.findElement(LoginPage.pwdInput).sendKeys(pwd);
        // 点击登录按钮
        driver.findElement(LoginPage.loginButton).click();

    }

    // 把登录封装起来
    public static void loginPo(WebDriver driver,String email,String pwd) throws InterruptedException {

        //先点击切换
        driver.findElement(LoginPage.qiehuan).click();
        Thread.sleep(3000);
        //将控制权转交到iframe里面
        driver.switchTo().frame("x-URS-iframe1586256644347.8848");
        // 输入邮箱用户名
        driver.findElement(LoginPage.emailInput).sendKeys(email);
        // 输入密码
        driver.findElement(LoginPage.pwdInput).sendKeys(pwd);
        // 点击登录按钮
        driver.findElement(LoginPage.loginButton).click();

    }

}

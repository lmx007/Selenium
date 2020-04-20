package com.testing02.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class ActionsTest {

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
     * 在百度一下按钮上右键
     */
    @Test
    public void rightClickTest() throws InterruptedException {
        // 打开百度首页
        driver.get("https://www.baidu.com/");
        WebElement buttonBaidu = driver.findElement(By.id("su"));
        Thread.sleep(3000);
        // 实例化 Actions
        Actions actions = new Actions(driver);
        // 在百度按钮上右键    .perform() 代表执行
        actions.contextClick(buttonBaidu).perform();
        // 不带参数chrome 浏览器在左上角右键
        //actions.contextClick().perform();
        Thread.sleep(3000);
    }

    /**
     * 打开百度页面
     * 双击百度一下按钮
     */
     @Test
    public void doubleClickTest() throws InterruptedException {
         // 打开百度首页
         driver.get("https://www.baidu.com/");
         WebElement buttonBaidu = driver.findElement(By.id("su"));
         Thread.sleep(3000);
         // 实例化 Actions
         Actions actions = new Actions(driver);
         actions.doubleClick(buttonBaidu).perform();
         // 如果不传参数会在鼠标当前位置做双击
         //actions.doubleClick().perform();
         Thread.sleep(3000);
     }

    /**
     * 打开百度页面
     * 鼠标移动到 action 按钮
     * 那么显示 北京天气预报
     */
    @Test
    public void moveTo() throws InterruptedException {
        // 打开百度首页
        driver.get("https://www.baidu.com/");
        // 百度首页定位北京没有定位到
        WebElement element = driver.findElement(By.xpath("/html/head/body/div[1]/div[1]/div[3]/span//[@class='show-city-name']"));
        Thread.sleep(5000);
        // 实例化 Actions
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        Thread.sleep(5000);
        String city = driver.findElement(By.xpath("//*[@id=\"s_mod_weather\"]/div[1]/a/div[1]/span[1]/em")).getText();
        Assert.assertEquals(city,"北京");
    }
    /**
     * 把一个滑动拖到坐标的指定位置
     */
    @Test
    public void testDrop(){
        // 打开一个网址
        driver.get("");
        WebElement element = driver.findElement(By.id("drag"));
        // 实例化 Actions
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(element, 600,600).perform();

    }
    /**
     * 把一个滑动拖到另一个元素的上面位置
     */
    @Test
    public void dropTest(){
        // 打开一个网址
        driver.get("");
        // 定位要移动的第一个元素的
        WebElement element1 = driver.findElement(By.id("drag"));
        // 定位要移动到的第二个元素的位置
        WebElement element2 = driver.findElement(By.id("drag"));
        // 实例化 Actions
        Actions actions = new Actions(driver);
        //clickAndHold(element1)按照要移动的元素，moveToElement(element2)移到第二个元素的位置，然后释放第一个移动的元素release(element1)然后执行
        actions.clickAndHold(element1).moveToElement(element2).release(element1).perform();
    }
    /**
     * 下拉框选中3个文件
     */
    @Test
    public void moreSelectTest() throws InterruptedException {
        // 打开一个网址
        driver.get("");
        WebElement element = driver.findElement(By.id(""));
        List<WebElement> list = driver.findElements(By.xpath(""));
        Thread.sleep(5000);
        // 实例化 Actions
        Actions actions = new Actions(driver);
        //keyDown(Keys.SHIFT)按下Shift键 ，click(list.get(0))点击第一个
        //click(list.get(2))点击到第三个，keyUp(Keys.SHIFT)抬起shift按键，然后执行  "CONTROL" 代表ctrl 键
        actions.keyDown(Keys.SHIFT).click(list.get(0)).click(list.get(2)).keyUp(Keys.SHIFT).perform();
        Thread.sleep(5000);

    }

    /**
     * 用robot 中模拟键盘ctrl+s 和 enter回车键 保存
     */
    @Test
    public void saveHtml() throws AWTException, InterruptedException {
        // 打开百度首页
        driver.get("https://www.baidu.com/");
        Robot robot = new Robot();
        //keyPress 按住 KeyEvent.VK_CONTROL ctrl键，KeyEvent.VK_S s键
        // 下面这2行代码就是按住ctrl+s 键
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(3000);
        // 按住回成键  Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        //释放ctrl + s 按键
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_S);
    }
    /**
     * 用sendkeys方法上传 图片
     */
    @Test
    public void uploadTest() throws InterruptedException {
        // 打开百度首页
        driver.get("https://www.baidu.com/");
        // 定位上传按钮 和 sendKeys里面放("图片的存放地址")
        driver.findElement(By.id("load")).sendKeys("图片的存放地址");
        Thread.sleep(5000);

    }

}

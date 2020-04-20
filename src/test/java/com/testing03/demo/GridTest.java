package com.testing03.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {

    @Test
    public void  testChrome() throws MalformedURLException, InterruptedException {
    // 创建一个DesiredCapabilities 类型
    DesiredCapabilities dc = DesiredCapabilities.chrome();
    // 实例化一个driver    URL("http://10.100.254.3:5555/wd/hub"),dc 代表启动chrome浏览器   ip是变化的
    WebDriver driver = new RemoteWebDriver(new URL("http://10.100.254.3:5555/wd/hub"),dc);

    driver.get("http://www.baidu.com");
    Thread.sleep(10000);
    driver.quit();

    }
    // 可以用5555的机器跑firefox ，然后用5558的机器跑chrome
    @DataProvider(name = "data4")
    public Object[][] test1(){
        return new Object[][]{
                {"firefox","http://10.100.254.3:5555"},
                {"chrome","http://10.100.254.3:5558"}
        };
    }
    // 通过数据驱动，一段代码可以在chrome和firefox 上面跑用例
    @Test(dataProvider = "data4")
    public void testGrid2(String browser,String url) throws InterruptedException, MalformedURLException {

        DesiredCapabilities dc = null;
        if(browser.equals("firefox") ){
            dc = DesiredCapabilities.firefox();
        }else if (browser.equals("chrome") ){
            dc = DesiredCapabilities.chrome();
        }else {
            System.out.println("error");
        }

        // 实例化一个driver    URL("http://10.100.254.3:5555/wd/hub"),dc 代表启动chrome浏览器   ip是变化的
        WebDriver driver = new RemoteWebDriver(new URL(url + "/wd/hub"),dc);

        driver.get("http://www.baidu.com");
        Thread.sleep(10000);
        driver.quit();

    }


}

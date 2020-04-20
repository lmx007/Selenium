package com.po.page;

import org.openqa.selenium.By;

public class LoginPage {

    //先点击切换
    public static By qiehuan = By.id("lbNormal");
    //定义 email 文本框的定位方式
    public static By emailInput = By.name("email");
    //定义 密码pwd 文本框的定位方式
    public static By pwdInput = By.name("password");
    //定义 登录按钮的定位方式
    public static By loginButton = By.name("dologin");
    // 去注册
    public static By zhuceButton = By.id("changepage");
}

package com.testing04.demo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDriverTest {

    // DataProvider数据驱动   返回类型一定是Object [][] ,
    // 第一种是写死的方法
    @DataProvider(name = "loginUser")
    public Object [][] data1(){
        return new Object[][]{
                {"user1","pwd1"},
                {"user2","pwd2"},
                {"user3","pwd3"},
                {"user4","pwd4"}
        };
    }
    @Test(dataProvider = "loginUser")
    public void loginTest(String user,String pwd){
        System.out.println("user:用户名"+user);
        System.out.println("pwd:密码"+pwd);
    }




}

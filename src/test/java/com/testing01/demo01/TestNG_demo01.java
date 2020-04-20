package com.testing01.demo01;

import org.testng.annotations.*;

public class TestNG_demo01 {

    @BeforeTest
    public void beforeTest01(){
        System.out.println("这是@BeforeTest注解");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("这是@BeforeMethod注解");
    }
    @Test
    public  void  testCase1(){
        System .out.print("这是@Test注解,case1");
    }
    @Test
    public void testCase2(){
        System.out.println("这是@Test注解,case2");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("这是@AfterMethod注解");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("这是@AfterTest注解");
    }

}

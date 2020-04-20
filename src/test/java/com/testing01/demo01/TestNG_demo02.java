package com.testing01.demo01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_demo02 {
    //          校验 a == a
    @Test
    public void assertEqualTest() {
        String a = "abcd";
        String b = "abcd1111";
//         b代表预期值，a 代表是实际值
        Assert.assertEquals(a, b, "a不等于b");
//        System.out.println("------------------------------");
//        Assert.assertEquals(a,b);
    }

    @Test
    public void assertNotEqualTest() {
        String a = "100";
        String b = "200";
        Assert.assertNotEquals(a, b);
    }

    @Test
    public void assertNullTest() {
        String a = null;
        Assert.assertNull(a);
    }
    @Test
    public void asserNotNullTest() {
        String a = "bb";
        Assert.assertNotNull(a);
    }
    @Test
    public void aTest() {
        Boolean a = false;
        Assert.assertFalse(a);
    }
    @Test
    public void bTest() {
        Boolean a = true;
        Assert.assertTrue(a);
    }

}




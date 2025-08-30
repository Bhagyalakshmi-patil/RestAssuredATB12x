package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class APITesting024_All_Annotations {
    @BeforeMethod
    void demo4(){
        System.out.println("BeforeMethod");
    }
    @Test
    void demo5(){
        System.out.println("Test");
    }
    @AfterMethod
    void demo6(){
        System.out.println("AfterMethod");
    }
}

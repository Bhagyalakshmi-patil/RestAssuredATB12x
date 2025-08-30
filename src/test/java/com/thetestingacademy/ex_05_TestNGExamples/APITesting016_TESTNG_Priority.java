package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.annotations.Test;

public class APITesting016_TESTNG_Priority {
// 0 is the max priority we can set , if u set negative(-1) , it is also considered as 0 itself
    @Test(priority = 1)
    public void test_t1(){
        System.out.println("1");
    }
    @Test(priority = 3)
    public void test_t2(){
        System.out.println("3");
    }
    @Test(priority = 2)
    public void test_t3(){
        System.out.println("2");
    }
    @Test(priority = 4)
    public void test_t4(){
        System.out.println("4");
    }
}

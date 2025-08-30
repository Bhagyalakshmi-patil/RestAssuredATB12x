package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.annotations.Test;

public class APITesting022_TestNG_invocationCount {

    // Run 2 times
    @Test(invocationCount = 2)
    public void test01(){
        System.out.println("Hi");
    }
    //Run 3 times
    @Test(invocationCount = 3)
    public void test02(){
        System.out.println("Bye");
    }
}

package com.thetestingacademy.ex_06_TestAssertions;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting026_TestNG_Assertions {

    @Test(enabled = true)
    public void test_hardAssertExample(){
        System.out.println("Start of the program");
        Assert.assertEquals("pramod","Pramod");
        System.out.println("End of the program");
    }

    //Soft Assertion
    // If u don't want to stop the execution and continue the execution even if validation returns false, then you can use
    // soft Assert
    @Test
    public void test_softAssertExample(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("pramod", "Pramod");
        System.out.println("End of the program");
        softAssert.assertAll();
    }
}

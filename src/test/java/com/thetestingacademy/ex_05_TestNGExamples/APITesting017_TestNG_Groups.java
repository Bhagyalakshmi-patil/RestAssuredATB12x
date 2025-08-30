package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting017_TestNG_Groups {

    // here , Reg - means run Sanity, reg and Smoke
    //        Sanity - means run sanity only
    //        Smoke -  means run smoke only
    //        We can do include and exclude also
    @Test(groups = {"sanity","reg"})
    public void test_sanityRun(){
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }
    @Test(groups = {"reg"})
    public void test_regRun(){
        System.out.println("Reg");
        Assert.assertTrue(false);
    }
    @Test(groups = {"smoke","reg"})
    public void test_smokeRun(){
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }

}

package com.thetestingacademy.ex_04_RestAssured_HTTP_Methods.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting009_GET_NONBDDStyle {

    // Divide them into 3 parts - R
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    String pincode;

    @Test
    public void test_GET_NON_BDD_STYLE(){
         pincode = "560048";
         //Given() - part1
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+pincode);

        //When - part2
        response = r.when().log().all().get();
        System.out.println(response.asString());

        //Then - part3 - validation

        vr = response.then().log().all();
        vr.statusCode(200);
        //write the further testcases or assertions also here
    }
    @Test
    public void test_GET_NON_BDD_STYLE_NEGATIVE(){
        pincode = "@";
        //Given() - part1
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+pincode);

        //When - part2
        response = r.when().log().all().get();
        System.out.println(response.asString());

        //Then - part3 - validation

        vr = response.then().log().all();
        vr.statusCode(404);
        //write the further testcases or assertions also here
    }
}

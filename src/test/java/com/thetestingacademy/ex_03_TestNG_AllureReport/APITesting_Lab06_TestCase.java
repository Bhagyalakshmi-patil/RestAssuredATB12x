package com.thetestingacademy.ex_03_TestNG_AllureReport;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting_Lab06_TestCase {

    @Test
    public void test_GET_POSITIVE_TC1(){
        String pincode = "110048";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);
    }
    @Test
    public void test_GET_POSITIVE_TC2(){
        String pincode = "110048";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);
    }
    @Test
    public void test_GET_POSITIVE_TC3(){
        String pincode = "110048";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);
    }
}

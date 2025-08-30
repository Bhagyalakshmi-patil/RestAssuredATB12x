package com.thetestingacademy.ex_07_Payload_management.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class APITesting028_RestAssured_Payload_Map {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String token;
    Integer BookingId;

    @Test
    public void test_createBooking_POST() {
        //String payload
//        String payload = "{\n" +
//                "    \"firstname\" : \"Pramod\",\n" +
//                "    \"lastname\" : \"Brown\",\n" +
//                "    \"totalprice\" : 111,\n" +
//                "    \"depositpaid\" : true,\n" +
//                "    \"bookingdates\" : {\n" +
//                "        \"checkin\" : \"2018-01-01\",\n" +
//                "        \"checkout\" : \"2019-01-01\"\n" +
//                "    },\n" +
//                "    \"additionalneeds\" : \"Breakfast\"\n" +
//                "}";

        //Hashmap -> key and value pair
        //Parent Hashmap -> key and value , Child Hashmap
        Map<String, Object> jsonBodyUsingMap = new LinkedHashMap<>();
        jsonBodyUsingMap.put("firstname", "Pramod");
        jsonBodyUsingMap.put("lastname", "Brown");
        jsonBodyUsingMap.put("totalprice", 111);
        jsonBodyUsingMap.put("depositpaid", true);

        Map<String,Object> bookingDatesMap = new LinkedHashMap<>();
        bookingDatesMap.put("checkin","2018-01-01");
        bookingDatesMap.put("checkout","2019-01-01");

        jsonBodyUsingMap.put("bookingdates",bookingDatesMap );
        jsonBodyUsingMap.put("additionalneeds", "Breakfast");
        System.out.println(jsonBodyUsingMap);

        //Hashmap -> JSON? or class -> JSON, String -> JSON
        //1. Gson
        //2. Jackson API  (Libraries)
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonBodyUsingMap).log().all();

        response = requestSpecification.when().post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
    }
}

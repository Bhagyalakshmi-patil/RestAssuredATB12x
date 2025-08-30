package com.thetestingacademy.ex_04_RestAssured_HTTP_Methods.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting012_PATCH_NONBDDStyle {

    @Test
    public void test_patch_non_bdd(){
        String token = "c29ea70c524b29b";
        String bookingid = "4856";

        String payloadPatch = "{\n" +
                "    \"firstname\" : \"Lucky\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);

        requestSpecification.body(payloadPatch).log().all();

        Response response = requestSpecification.when().patch();

        ValidatableResponse validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);
    }
}

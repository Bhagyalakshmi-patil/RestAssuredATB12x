package com.thetestingacademy.ex_04_RestAssured_HTTP_Methods.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting011_PUT_NONBDDStyle {
    //PUT
    //token, booking id - A
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public  void test_put_non_bdd(){
        String token = "993f3e8082d0f7e";
        String bookingid = "1161";
        String payload = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingid);
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
      //  r.header("api-key","abc");
      //  r.header("bearer","xyz");
      //  r.auth().basic();
        r.body(payload).log().all();
        response = r.when().log().all().put();

        vr = response.then().log().all();
        vr.statusCode(200);
    }
}

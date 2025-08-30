package com.thetestingacademy.ex_06_TestAssertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class APITesting027_RestAssured_TestNG_AssertJ_Assertions {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String token;
    Integer BookingId;

    @Test
    public void test_createBooking_POST(){
        //String payload
        String payload = "{\n" +
                "    \"firstname\" : \"Pramod\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload).log().all();

        response = requestSpecification.when().post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        validatableResponse.body("bookingid", Matchers.notNullValue());
        validatableResponse.body("booking.firstname", Matchers.equalTo("Pramod"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Brown"));
        validatableResponse.body("booking.depositpaid", Matchers.equalTo(true));

        // TestNG - Extract the details of the firstName, bookingid, lastname

        Integer bookingId = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");

        //TestNG Assertions - 75%
        //SoftAssert vs HardAssert
        //This means that if any assertion fails, the remaining statements in that method will not be executed.

        Assert.assertEquals(firstname,"Pramod");
        Assert.assertEquals(lastname, "Brown");
        Assert.assertNotNull(bookingId);

        //AssertJ(3rd - Lib to Assertions) - 20%
        assertThat(bookingId).isNotNull().isPositive().isNotZero();
        assertThat(firstname).isNotEmpty().isNotBlank().isNotNull().isEqualTo("Pramod");

        // Difference between blank and empty
        // String n = "" ; Empty
        // String n = " "; Blank
    }
}

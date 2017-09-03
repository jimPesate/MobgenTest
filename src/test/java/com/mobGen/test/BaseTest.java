package com.mobGen.test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.junit.*;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class BaseTest {


    protected RequestSpecification requestSpecification = null;


    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://halo-new-int.mobgen.com";
    }

    @Before
    public void getAuthToken() {

        HashMap<String, String> params = new HashMap<>();
        params.put("grant_type", "password");
        params.put("username", "test.admin@assignment.com");
        params.put("password", "aA12345*");

        JsonPath jsonPath = given().contentType("application/json")
                .body(params)
                .post("/api/oauth/token?_user")
                .then()
                .assertThat().statusCode(200)
                .extract()
                .body().jsonPath();

        String accessToken = jsonPath.getString("access_token");
        String tokenType = jsonPath.getString("token_type");

        Assert.assertNotNull("Couldn't get AuthToken", accessToken);
        Assert.assertNotNull("Couldn't get Token Type", tokenType);


        requestSpecification = new RequestSpecBuilder()
                .addHeader("Authorization", tokenType + " " + accessToken)
                .build();

    }

    @After
    public void finish() {
        RestAssured.reset();
    }

}

package com.mobGen.test;

import com.mobGen.test.model.Module;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetModuleListTest extends BaseTest {

    //Get all Modules (with limit and pagination)
    @Test
    public void testGetList() {

        System.out.println("GET LIST - Testing");

        HashMap<String, Object> params = new HashMap<>();
        params.put("page", 1);
        params.put("limit", 10);

        List<Module> modules = given().spec(requestSpecification).params(params)
                .get("/api/generalcontent/module")
                .then().log().ifValidationFails()
                .assertThat().statusCode(200)
                .extract().jsonPath().getList("items", Module.class);

        System.out.println("GET LIST - Success");

    }

}

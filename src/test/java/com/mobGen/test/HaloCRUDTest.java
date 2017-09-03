package com.mobGen.test;

import com.mobGen.test.model.Module;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.junit.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class HaloCRUDTest extends BaseTest {

    private Module module;
    private final String name = "Halo API CRUD Test";
    private final String nameUpdated = "Halo Update CRUD Test (updated)";


    //Here we test every step of a CRUD (Create, Read, Update, Delete) Test
    //It is done this way to avoid having to manually enter the require data
    //for each test. This way it recycles the data from one test case to another.
    @Test
    public void testIntegration() {

        testCreate();
        testGet();
        testUpdate();
        testDelete();

    }

    //Create Module
    public void testCreate() {

        System.out.println("CREATE - Testing");


        HashMap<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("isSingle", false);

        module = given().spec(requestSpecification).body(params)
                .contentType("application/json")
                .post("/api/generalcontent/module/")
                .then()
                .log().ifValidationFails()
                .assertThat().statusCode(200)
                .extract().as(Module.class);

        System.out.println("CREATE - Success");

    }


    //Read single Module
    public void testGet() {

        System.out.println("GET - Testing");

        Module getModule = given().spec(requestSpecification)
                .get("/api/generalcontent/module/" + module.getId())
                .then()
                .log().ifValidationFails()
                .assertThat().statusCode(200)
                .extract().as(Module.class);

        Assert.assertEquals("GET - Module obtained does not match created module", getModule, module);

        System.out.println("GET - Success");
    }


    //Update Module
    public void testUpdate() {

        System.out.println("UPDATE - Testing");


        HashMap<String, Object> params = new HashMap<>();
        params.put("name", nameUpdated);

        given().spec(requestSpecification).body(params)
                .contentType("application/json")
                .put("/api/generalcontent/module/" + module.getId())
                .then()
                .log().ifValidationFails()
                .assertThat().statusCode(200)
                .and().body("name", equalTo(nameUpdated));

        System.out.println("UPDATE - Success");

    }

    //Delete Module
    public void testDelete() {

        System.out.println("DELETE - Testing");


        given().spec(requestSpecification)
                .contentType("application/json")
                .delete("/api/generalcontent/module/" + module.getId())
                .then()
                .log().ifValidationFails()
                .assertThat().statusCode(200);

        System.out.println("DELETE - Success");
    }

}
package com.redhat.developers;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PlacesResourceTest {

    @Test
    public void testGetPlaces(){
        given()
          .when().get("/places")
          .then()
             .statusCode(200)
             .body(containsString("Oslo"));

    }
}

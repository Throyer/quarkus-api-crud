package com.github.throyer.common.quarkus.api;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class HomeControllerTests {

    @Test
    public void home_works() {
        var response = "{\"message\":\"Is a live!\"}";
        given()
            .when()
                .get("/")
            .then()
                .statusCode(200)
            .body(is(response));
    }

}
package com.delkabo;

import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Test;

import static com.delkabo.Specs.request;
import static com.delkabo.Specs.responseSpec;
import static io.restassured.RestAssured.given;

public class UserTest {
    @Test
    void singleUser() {
        given()
                .spec(request)
        .when()
                .get("/users/2")
        .then()
                .spec(responseSpec)
                .log().body();
    }
}

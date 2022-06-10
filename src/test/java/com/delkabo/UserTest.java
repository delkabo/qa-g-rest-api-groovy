package com.delkabo;

import com.delkabo.models.UserData;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Test;

import static com.delkabo.Specs.request;
import static com.delkabo.Specs.responseSpec;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void singleUserWithModel() {
        UserData data = given()
                .spec(request)
                .when()
                .get("/users/2")
                .then()
                .spec(responseSpec)
                .log().body()
                .extract().as(UserData.class);

        assertEquals(2, data.getData().getId());
    }
}

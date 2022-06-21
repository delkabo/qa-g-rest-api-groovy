package com.delkabo;

import com.delkabo.models.UserData;
import org.junit.jupiter.api.Test;

import static com.delkabo.Specs.request;
import static com.delkabo.Specs.responseSpec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
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

    @Test
    void singleUserWithModelAsText() {
        String data = given()
                .spec(request)
                .when()
                .get("/users/2")
                .then()
                .spec(responseSpec)
                .log().body()
                .extract().asString();

        System.out.println("My request = " + data);
    }

    @Test
    public void checkEmailUsingGroovy() {
        given()
                .spec(request)
                .when()
                .get("/users")
                .then()
                .log().body()
                .body("data.findAll{it.email =~/.*?@reqres.in/}.email.flatten()",
                        hasItem("eve.holt@reqres.in"));
    }


}

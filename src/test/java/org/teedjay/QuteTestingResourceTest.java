package org.teedjay;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

@QuarkusTest
class QuteTestingResourceTest {

    @Test
    void testing() {
        given()
            .when().get("/qutetesting")
            .then()
            .statusCode(200)
            .body(containsString("[abc, def, ghj]"));
    }

}

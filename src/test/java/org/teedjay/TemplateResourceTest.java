package org.teedjay;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
public class TemplateResourceTest {

    @Test
    public void testWithSingleInput() {
        given()
            .when().get("/template/single")
            .then()
                .statusCode(200)
                .body(containsString("Ingen kvittering i dag!"));
    }

    @Test
    public void testWithMultipleInputs() {
        given()
            .when().get("/template/multiple")
            .then()
                .statusCode(200)
                .body(containsString("Varslingskanal : EPOST"));
    }

}
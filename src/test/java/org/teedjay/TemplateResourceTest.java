package org.teedjay;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class TemplateResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("\n" +
                     "        Article - My Article\n" +
                     "        Authors: \n" +
                     "        - Mr. Foo\n" +
                     "        - Mr. Bar"));
    }

}
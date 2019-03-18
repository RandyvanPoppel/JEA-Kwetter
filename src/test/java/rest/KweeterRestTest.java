package rest;

import io.restassured.RestAssured;
import models.Kweeter;
import org.junit.*;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static io.restassured.RestAssured.given;

public class KweeterRestTest {
    @Before
    public void setUp() {
        RestAssured.port = 8080;
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "/JEA-Kwetter-1.0/api/";
    }

    @Test
    public void basicTest() {
        given().when().get("/nonExistingRoute").then().statusCode(404);
    }

    @Test
    public void addKweeter2() {

        Kweeter kweeter = new Kweeter("testKweeter");

        Kweeter returnKweeter =
                given().
                        contentType("application/json").
                        body(kweeter).
                        when().
                        post("/kweeter/add2").as(Kweeter.class);

        assertThat(returnKweeter, is(kweeter));
    }
}

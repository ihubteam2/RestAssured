import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredSession {

    @Test
    public void testGetMethod(){

         given().contentType("application/json")
        .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                 .body("data.email[0]",equalTo("michael.lawson@reqres.in"));

    }


    @Test
    public void testPostMethod() {

        String testBody = "{\n" +
                "\"name\": \"morpheus\",\n" +
                "\"job\": \"leader\"\n" +
                "}";

        given().contentType("application/json")
                .when()
                .body(testBody)
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201);
    }

    @Test
    public void testPostMethodUsingHashMap() {

        Map<String, String> postBody = new HashMap<String, String>();
        postBody.put("name","morpheus");
        postBody.put("job","leader");

        given().contentType(ContentType.JSON)
                .when()
                .body(postBody)
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .log();

    }

    @Test
    public void testPostMethodUsingJsonFile() throws Exception {

        File dataFile = new File("src/main/resources/data.json");
        given().contentType(ContentType.JSON)
                .when()
                .body(dataFile)
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .log();

    }

}

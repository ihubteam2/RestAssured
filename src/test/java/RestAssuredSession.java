import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
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
    public void testPostMethod(){

    }

}

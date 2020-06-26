package Utils;

import io.restassured.response.Response;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseLine_API {

    public static Response response;
    //private JSONpath jsonPath;
    private Map<String,String>queryParamter = new HashMap<>();

    // Constructor  will get call as soon as object of this class initiates.
    public BaseLine_API(){

    }
    public void doGetRequest(String apiURL){
        response= given().contentType("application/json")
                  .when()
                  .get(apiURL);
    }
    public void validateResponseCode(int statusCode){
        Assert.assertEquals(statusCode, response.getStatusCode());
    }
    public void extractAttributeValue(String attributeName){
        String res = response.toString();
        //JSONPath.with(res).get(attributeName);
    }

    public void addQueryParams(String key, String value){
        this.queryParamter.put(key, value);
    }
    public void doPostRequst(String apiURL){
        response= given()
                .header("Content-Type","application/json")
                .body(PayLoad.postUser())
                .when()
                .post(apiURL);

    }

}

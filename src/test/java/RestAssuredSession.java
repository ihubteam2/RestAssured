import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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

    @Test
    public void testPostMethodUsingPojoObject(){

        User user = new User("morpheus","leader" );
        given().contentType(ContentType.JSON)
                .when()
                .body(user)
                .post(Constants.baseURI+Constants.basePath+Constants.endPoint)
                .then()
                .statusCode(201)
                .log().all();
    }

    @Test
    public void testPostMethodURLbuildingConfigurations() throws IOException {

        Properties configProperties = new Properties();
        FileInputStream configFile = new FileInputStream("./src/main/resources/Configuration.properties");
        configProperties.load(configFile);

        User user = new User("morpheus","leader" );
        given().contentType(ContentType.JSON)
                .when()
                .body(user)
                .post(configProperties.getProperty("baseURI")+configProperties.getProperty("basePath")+configProperties.getProperty("endPoint"))
                .then()
                .statusCode(201)
                .log().all();
    }

    @Test(dataProvider="xlData")
    public void testPostMethodUsingExcelSheetData(String name, String job) throws Exception {

        JSONObject testxlData = new JSONObject();
        testxlData.put("name",name);
        testxlData.put("job",job);

        given().contentType(ContentType.JSON)
                .when()
                .body(testxlData)
                .post(Constants.baseURI+Constants.basePath+Constants.endPoint)
                .then()
                .statusCode(201)
                .log().all();

    }

    @DataProvider(name="xlData")
    public Object[][] getxlData() throws IOException {
        String excelPath = "./src/main/resources/userData.xlsx";
        Object data[][]= excelData(excelPath,"testData");
        return data;
    }


    public Object[][] excelData(String excelPath,String sheetName) throws IOException {
        ExcelUtils xlutils = new ExcelUtils(excelPath, sheetName);
        int rowCount = xlutils.getRowCount();
        int columnCount = xlutils.getColumnCount();

        Object[][] data = new Object[rowCount][columnCount];
        for(int i=1; i<rowCount; i++){
            for(int j=0; j<columnCount; j++){
                String cellData = xlutils.getCellData(i,j);
                data[i-1][j]= cellData;
            }
        }
        return data;
    }

    @Test
    public void testPUTmethod(){

        Map<String, String> putBody = new HashMap<String, String>();
        putBody.put("name","morpheus");
        putBody.put("job","Tutor");

        given().contentType(ContentType.JSON)
                .when()
                .body(putBody)
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .log().all();

    }

    @Test
    public void testPATCHmethod(){

        Map<String, String> putBody = new HashMap<String, String>();
        putBody.put("name","RESTAOI");
        putBody.put("job","WELCOME");

        given().contentType(ContentType.JSON)
                .when()
                .body(putBody)
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .log().all();

    }

    @Test
    public void testDELETEmethod(){
        given().contentType(ContentType.JSON)
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(204)
                .log().all();
    }

}

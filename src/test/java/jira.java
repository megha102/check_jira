import com.jayway.restassured.path.json.JsonPath;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class jira {

    @Test
    public void jiraApi()
    {

        //create issue

        String b = "{"+
	"\"fields\": {"+
        "\"project\": {"+
          "\"key\": \"RES\""+
       " },"+
        "\"summary\": \"Not Saving the Rule\","+
        "\"issuetype\": {"+
          "\"name\": \"Bug\""+
        "},"+
        "\"description\": \"We have another bug over here\""+
	"}"+
"}";


        RestAssured.baseURI = "http://localhost:8080";

        Response res  = (Response) given().header("Content-Type","application/json").
                header("Cookie","JSESSIONID="+ResusableMethods.getSessionKey()).
                body(b).when().post("/rest/api/2/issue").
                then().statusCode(201).
                extract().response();

        String resp = res.jsonPath().get("id");

        System.out.println(resp);
    }

}

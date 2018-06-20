import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class update_comment {

    @Test
    public static void Update_Comment()
    {
        RestAssured.baseURI = "http://localhost:8080";

        String b = " {"+
      "\"body\": \"yo tyo\","+
      "\"visibility\": {"+
        "\"type\": \"role\","+
        "\"value\": \"Administrators\""+
      "}"+
    "}";

        Response res  = (Response) given().header("Content-Type","application/json").
                header("Cookie","JSESSIONID="+ResusableMethods.getSessionKey()).
                body(b).when().put("/rest/api/2/issue/10003/comment/10009").
                then().statusCode(200).extract().response();

        String res_string = res.asString();
        System.out.println(res_string);




    }







}

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class add_comment {

    @Test
    public static void Add_comment()
    {

        RestAssured.baseURI = "http://localhost:8080";

        String b = "{"+
      "\"body\": \"hey\","+
      "\"visibility\": {"+
        "\"type\": \"role\","+
        "\"value\": \"Administrators\""+
      "}"+
                "}";

        Response res  = (Response) given().header("Content-Type","application/json").
                header("Cookie","JSESSIONID="+ResusableMethods.getSessionKey()).
                body(b).when().post("rest/api/2/issue/10003/comment").
                then().statusCode(201).extract().response();


        String res_string = res.jsonPath().get("self");
        System.out.println(res_string);



    }


}

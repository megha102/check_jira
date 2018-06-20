import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ResusableMethods {

    public static String getSessionKey()
    {
        //creating session

        RestAssured.baseURI = "http://localhost:8080";

        Response res  = given().header("Content-Type","application/json").
                body("{ \"username\": \"meghagulati03\", \"password\": \"awe21494\" }").

                when().
                post("/rest/auth/1/session").

                then().statusCode(200).
                extract().response();

        String session_id = res.jsonPath().get("session.value");

        return session_id;


    }

}

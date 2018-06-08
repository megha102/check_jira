import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;


public class basics {

    public static void main(String args[])
    {
        //basic url
        RestAssured.baseURI = "https://maps.googleapis.com";

        //what all do we have i.e. only parameters
       given().
                param("loacation","-33.8670522,151.1957362").
                param("radius","1500").
                param("key","AIzaSyCsBp2KYv42W6PIeuGH5OsnAdY4o7E7hoI").
                when().
                get("/maps/api/place/nearbysearch/json").
                then().
                assertThat().statusCode(200);


    }
}

import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class IntegrationTests {
    ValidatableResponse response;


    @Test
    public void testWithString(){

        String stringValue = "test";

     response =   given().
                when().
                get("http://localhost/staircase/stairs/N http://localhost/staircase/stairs/"+stringValue)
                .then().log().all();

     response.statusCode(400);
    }

    @Test
    public void testWithNegativeValues(){

        int negativeValue = -3;

        response =   given().
                when().
                get("http://localhost/staircase/stairs/N http://localhost/staircase/stairs/"+negativeValue)
                .then().log().all();

        response.statusCode(400);
    }

    @Test
    public void testWithNull(){

        String nullValue = null;

        response =   given().
                when().
                get("http://localhost/staircase/stairs/N http://localhost/staircase/stairs/"+nullValue)
                .then().log().all();

        response.statusCode(400);
    }

}

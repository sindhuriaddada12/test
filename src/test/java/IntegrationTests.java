import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class IntegrationTests {
    ValidatableResponse response;


    @Test
    public void testInvalidData(){

        String stringValue = "test";

     response =   given().
                when().
                get("http://localhost/staircase/stairs/N http://localhost/staircase/stairs/"+stringValue)
                .then().log().all();

     response.statusCode(400);
    }

}

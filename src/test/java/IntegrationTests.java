import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertTrue;


public class IntegrationTests extends Base {

    String path = "http://localhost/staircase/stairs/";


    @Test
    public void testWithString() {

        String stringValue = "string";
        get(path, stringValue);

        isBadRequest();
    }

    @Test
    public void testWithNegativeValues() {

        int negativeValue = -3;
        get(path, negativeValue);
        // Even though this works with given code, In testing point of view I expect this to fail

        isBadRequest();
    }

    @Test
    public void testWithValueZero() {

        get(path, 0);
        // Even though this works with given code, In testing point of view I expect this to fail
        isBadRequest();

    }

    @Test
    public void testWithValueOne() {

        get(path, 1);
        isOK();
        assertTrue(isContainsString(jsonAsString(getResponse()), "1"));
    }

    @Test
    public void testWithValueTwo() {

        get(path, 2);
        isOK();
        assertTrue(isContainsString(jsonAsString(getResponse()), "2"));
    }

    @Test
    public void testWithValueThree() {


        get(path, 3);
        isOK();
        assertTrue(isContainsString(jsonAsString(getResponse()), "3"));
    }

    @Test
    public void testWithValueFour() {


        get(path, 4);
        isOK();
        assertTrue(isContainsString(jsonAsString(getResponse()), "5"));
    }


}

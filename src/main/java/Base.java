import io.restassured.config.JsonConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;

public class Base {

    private ValidatableResponse response;

    public ValidatableResponse getResponse() {
        return response;
    }

    public void setResponse(ValidatableResponse response) {
        this.response = response;
    }


    RequestSpecification rs = given().log().all().config(RestAssuredConfig.config()
            .jsonConfig((JsonConfig.jsonConfig().numberReturnType(JsonPathConfig.NumberReturnType.BIG_DECIMAL))))
            .relaxedHTTPSValidation().
                    when();


    protected ValidatableResponse get(String path, String param) {

        setResponse(rs
                .get(path + param)
                .then().log().all());
        return getResponse();

    }

    protected ValidatableResponse get(String path, int param) {

        setResponse(rs
                .get(path + param)
                .then().log().all());
        return getResponse();

    }

    protected ValidatableResponse isOK() {

        return response.statusCode(200);
    }

    protected ValidatableResponse isUnauthorized() {

        return response.statusCode(401);
    }

    protected ValidatableResponse isBadRequest() {

        return response.statusCode(200);
    }

    protected ValidatableResponse isNotFound() {

        return response.statusCode(404);
    }

    protected String jsonAsString(ValidatableResponse response) {

        return response.extract().asString();

    }

    public static boolean isContainsString(String source, String subItem) {
        String pattern = "\\b" + subItem + "\\b";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(source);
        return m.find();
    }

}

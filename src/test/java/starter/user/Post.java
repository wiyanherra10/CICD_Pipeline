package starter.user;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.equalTo;

public class Post {
    protected static String url = "https://jsonplaceholder.typicode.com/";

    //Scenario: [Positive] - Verify user POST new post
    @Step("I set an endpoint for POST new user")
    public String setPostEndpoint(){
        return url + "posts";
    }

    @Step("I request POST detail user")
    public void reqPostDetailUser(){
        JSONObject requestData = new JSONObject();
        requestData.put("id", 101);
        requestData.put("title", "RESTful API Testing with Rest Assured");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body(requestData.toString());

        SerenityRest.when().post(setPostEndpoint());
    }

    @Step("I receive valid HTTP response code 201")
    public void validHTTPresponse201(){
        then().statusCode(201);
    }

    @Step("I validate the data detail after create user")
    public void validateDataDetailAfterCreateUser(){
        SerenityRest.then().body("id", equalTo(101));
        SerenityRest.then().body("title", equalTo("RESTful API Testing with Rest Assured"));
    }

    //Scenario: [Negative] - Verify user POST new post with missing data
    @Step("I set a endpoint for POST new user")
    public String setPOSTNewUserEndpoint(){
        return url + "post";
    }

    @Step("I request POST detail user with missing data")
    public void reqPostDetailUserWithMissingData(){
        JSONObject requestData = new JSONObject();
        requestData.put("id", 101);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body(requestData.toString());

        SerenityRest.when().post(setPOSTNewUserEndpoint());
    }

    @Step("I receive invalid HTTP response code 404")
    public void invalidHTTPCoderesponse404() {
        then().statusCode(404);
    }

    @Step("I receive an error message Invalid input: missing field 'body'")
    public void invalidInputDetailUser(){
        SerenityRest.then().body("error", equalTo(null));
    }
}



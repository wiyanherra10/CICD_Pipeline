package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import static io.restassured.RestAssured.given;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.core.IsEqual.equalTo;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.not;

public class Get {
    protected static String url = "https://jsonplaceholder.typicode.com/";

    //Scenario: [Positive] - Verify user GET all posts
    @Step("I set GET endpoint")
    public String setGetEndpoint(){
        return url + "posts";
    }
    @Step("I send a GET HTTP request")
    public void sendGetHTTPRequest(){
        SerenityRest.given().when().get(setGetEndpoint());
    }
    @Step("I receive valid HTTP response code 200")
    public void validHTTPresponse200(){
        restAssuredThat(response -> response.statusCode(200));

    }
    @Step("I receive response valid data for a list of all posts")
    public void validData(){
        restAssuredThat(response -> response.body("[0].id", equalTo(1)));
        restAssuredThat(response -> response.body("[0].title",
                equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit")));
    }

    //Scenario: [Negative] - Verify user GET all posts with wrong endpoint
    @Step("I set GET endpoint to an invalid endpoint")
    public String setGetInvalidEndpoint(){
        return url + "wrong_endpoint";
    }
    @Step("I send an HTTP GET request")
    public void getHTTPRequest(){
        SerenityRest.given().when().get(setGetInvalidEndpoint());
    }
    @Step("Then I received HTTP response code 404")
    public void invalidHTTPresponse404(){
        restAssuredThat(response -> response.statusCode(404));

    }
    @Step("I should receive an error message 404 Not Found")
    public void invalidData(){

    }

    //Scenario: [Positive] - Verify user GET post by ID
    @Step("I set the GET endpoint URL to post with ID")
    public String setEndpointForPostWithID() {
        return url + "posts/";
    }

    @Step("I send a GET HTTP request to endpoint URL to post with ID")
    public void getToRequestID() {
        SerenityRest.given().when().get(setEndpointForPostWithID());
    }

    @Step("I verify that HTTP response code 200")
    public void verifyHTTPResponseCode200() {
        given()
                .get(setEndpointForPostWithID())
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Step("I receive response valid data for post with ID 1")
    public void receiveValidDataForPostWithID1() {
        given()
                .get(setEndpointForPostWithID())
                .then()
                .assertThat()
                .body("[0].id", equalTo(1))
                .body("[0].title",
                        equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
    }

    //Scenario: [Negative] - Verify user GET post by invalid ID
    @Step("I set the GET endpoint URL to invalid post ID")
    public String setGetInvalidPostidEndpoint() {
        url = "https://jsonplaceholder.typicode.com/posts/999";
        return url;
    }

    @Step("I send a GET HTTP request to endpoint URL to invalid post ID")
    public Response sendGetEndpointInvalidPostID() {
        return RestAssured.given().get(setGetInvalidPostidEndpoint());
    }

    @Step("I verify that HTTP response code is not 400")
    public void verifyHTTPResponseCodeIsNot() {
        restAssuredThat(response -> response.statusCode(not(404)));
    }

    @Step("I receive an error message with invalid post ID")
    public void errorMessageWithInvalidPostID(){

    }
}






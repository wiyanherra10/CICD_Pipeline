package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class Put {
    protected String url = "https://jsonplaceholder.typicode.com/";

    //Scenario: [Positive] - Verify user PUT post by ID

    @Step("I set PUT endpoints")
    public String setPutEndpoint() {
        return url + "posts/1";
    }

    @Step("I send PUT HTTP request")
    public void sendPutHttpRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("id", "1");
        requestBody.put("title", "Updated Title");
        requestBody.put("body", "This is the updated content of the post");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .put(setPutEndpoint());
    }

    @Step("I receive response with a valid HTTP status code 200")
    public void codeResponse() {
        SerenityRest.then().statusCode(200);
    }

    @Step("I receive valid data for existing user")
    public void ValidateDataForExistingUser() {
        restAssuredThat(response -> response.body("'id'", equalTo(1)));
        restAssuredThat(response -> response.body("'title'", equalTo("Updated Title")));
        restAssuredThat(response -> response.body("'body'",
                equalTo("This is the updated content of the post")));
    }

    //Scenario: [Negative] - Verify user PUT send invalid request for post by ID
    @Step("I set PUT endpoint for an existing post by ID")
    public String setPutEndpointId() {
        url = "https://jsonplaceholder.typicode.com/posts/999";
        return url;
    }

    @Step("I send an invalid PUT HTTP request with an empty request body")
    public void sendInvalidPutHTTPRequest() {
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body("{}")
                .put(setPutEndpoint());
    }

    @Step("I receive response with an invalid HTTP status code {int}")
    public void receiveResponseInvalidHTTPStatusCode(int code ) {
        restAssuredThat(response -> response.statusCode(code));
    }

    @Step("I receive an error message 'Request body is empty' in the response body")
    public void receiveErrorMessageInResponseBody() {
        restAssuredThat(response -> response.body("message", equalTo(null)));
    }
}


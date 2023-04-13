package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Delete {
    protected String url = "https://jsonplaceholder.typicode.com/";

    //Scenario: [Positive] - Verify user DELETE post by ID
    @Step("I set DELETE endpoint")
    public String setDeleteEndpoint() {
        return url + "posts/1";
    }

    @Step("I send DELETE HTTP request")
    public void sendDeleteHttpRequest() {
        SerenityRest.given().delete(setDeleteEndpoint());
    }

    @Step("I receive an valid HTTP response code 200")
    public void receiveValidResponseCode() {
        restAssuredThat(response -> response.statusCode(200));
    }

    //Scenario: [Negative] - Verify user cannot DELETE non-existing post by ID
    @Step("I set DELETE endpoint for a non-existing post")
    public String setDeleteEndpointForNonExistingPost(){
        url = "https://jsonplaceholder.typicode.com/posts/999";
        return url;
    }

    @Step("I send DELETE HTTP request for a non-existing post")
    public void sendDeleteHttpRequestForNonExistingPost(){
        SerenityRest.given().delete(setDeleteEndpoint());
    }
    @Step("I receive HTTP response code 404")
    public void receiveHttpresponseCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }
}



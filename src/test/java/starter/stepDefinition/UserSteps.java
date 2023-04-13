package starter.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Delete;
import starter.user.Get;
import starter.user.Post;
import starter.user.Put;

public class UserSteps {
    @Steps
    Get get;

    @Steps
    Post post;

    @Steps
    Put put;

    @Steps
    Delete delete;

    //Scenario: [Positive] - Verify user GET all posts
    @Given("I set GET endpoint")
    public void setGetEndpoint(){
        get.setGetEndpoint();

    }
    @When("I send a GET HTTP request")
    public void sendGetHTTPRequest(){
        get.sendGetHTTPRequest();

    }
    @Then("I receive valid HTTP response code 200")
    public void validHTTPresponse200(){
        get.validHTTPresponse200();

    }
    @And("I receive response valid data for a list of all posts")
    public void validData(){
        get.validData();
    }

    //Scenario: [Negative] - Verify user GET all posts with wrong endpoint
    @Given("I set GET endpoint to an invalid endpoint")
    public void setGetInvalidEndpoint(){
        get.setGetInvalidEndpoint();

    }
    @When("I send an HTTP GET request")
    public void getHTTPRequest(){
        get.getHTTPRequest();

    }
    @Then("Then I received HTTP response code 404")
    public void invalidHTTPresponse404(){
        get.invalidHTTPresponse404();

    }
    @And("I should receive an error message 404 Not Found")
    public void invalidData(){
        get.invalidData();
    }

    //Scenario: [Positive] - Verify user POST new post
    @Given("I set an endpoint for POST new user")
    public void setPostEndpoint() {
        post.setPostEndpoint();
    }

    @When("I request POST detail user")
    public void reqPostDetailUser() {
        post.reqPostDetailUser();
    }

    @Then("I receive valid HTTP response code 201")
    public void validHTTPresponse201() {
        post.validHTTPresponse201();
    }

    @And("I validate the data detail after create user")
    public void validateDataDetailAfterCreateUser() {
        post.validateDataDetailAfterCreateUser();
    }

    //Scenario: [Negative] - Verify user POST new post with missing data
    @Given("I set a endpoint for POST new user")
    public void setPOSTNewUserEndpoint() {
        post.setPOSTNewUserEndpoint();
    }

    @When("I request POST detail user with missing data")
    public void reqPostDetailUserWithMissingData() {
        post.reqPostDetailUserWithMissingData();
    }

    @Then("I receive invalid HTTP response code 404")
    public void invalidHTTPCoderesponse404() {
        post.invalidHTTPCoderesponse404();
    }

    @And("I receive an error message Invalid input: missing field 'body'")
    public void invalidInputDetailUser() {
        post.invalidInputDetailUser();
    }

    //Scenario: [Positive] - Verify user GET post by ID
    @Given("I set the GET endpoint URL to post with ID")
    public void setEndpointForPostWithID() {
        get.setEndpointForPostWithID();
    }

    @When("I send a GET HTTP request to endpoint URL to post with ID")
    public void getToRequestID() {
        get.getToRequestID();
    }

    @Then("I verify that HTTP response code 200")
    public void verifyHTTPResponseCode200() {
        get.verifyHTTPResponseCode200();
    }

    @And("I receive response valid data for post with ID 1")
    public void receiveValidDataForPostWithID1() {
        get.receiveValidDataForPostWithID1();
    }

    //Scenario: [Negative] - Verify user GET post by invalid ID
    @Given("I set the GET endpoint URL to invalid post ID")
    public void setGetInvalidPostidEndpoint() {
        get.setGetInvalidPostidEndpoint();
    }

    @When("I send a GET HTTP request to endpoint URL to invalid post ID")
    public void sendGetEndpointInvalidPostID() {
        get.sendGetEndpointInvalidPostID();
    }

    @Then("I verify that HTTP response code is not 400")
    public void verifyHTTPResponseCodeIsNot() {
        get.verifyHTTPResponseCodeIsNot();
    }

    @And("I receive an error message with invalid post ID")
    public void errorMessageWithInvalidPostID() {
        get.errorMessageWithInvalidPostID();
    }

    //Scenario: [Positive] - Verify user PUT post by ID
    @Given("I set PUT endpoint")
    public void setPutEndpoint() {
        put.setPutEndpoint();
    }

    @When("I send PUT HTTP request")
    public void sendPutHttpRequest() {
        put.sendPutHttpRequest();
    }

    @Then("I receive response with a valid HTTP status code 200")
    public void codeResponse() {
        put.codeResponse();
    }
    @And ("I receive valid data for existing user")
    public void ValidateDataForExistingUser() {
        put.ValidateDataForExistingUser();
    }

    //Scenario: [Negative] - Verify user PUT send invalid request for post by ID
    @Given("I set PUT endpoint for an existing post by ID")
    public void setPutEndpointExistingPostWithID() {
        put.setPutEndpointId();
    }

    @When("I send an invalid PUT HTTP request with an empty request body")
    public void sendInvalidPutHTTPRequest() {
        put.sendInvalidPutHTTPRequest();
    }

    @Then("I receive response with an invalid HTTP status code {int}")
    public void receiveResponseInvalidHTTPStatusCode(int code) {
        put.receiveResponseInvalidHTTPStatusCode(code);
    }

    @And("I receive an error message 'Request body is empty' in the response body")
    public void receiveErrorMessageInResponseBody() {
        put.receiveErrorMessageInResponseBody();
    }

    //[Positive] - Verify user DELETE post by ID
    @Given("I set DELETE endpoint")
    public void setDeleteEndpoint(){
        delete.setDeleteEndpoint();


    }
    @When("I send DELETE HTTP request")
    public void sendDeleteHttpRequest(){
        delete.sendDeleteHttpRequest();

    }

    @Then("I receive an valid HTTP response code 200")
    public void receiveValidResponseCode(){
        delete.receiveValidResponseCode();

    }

    //Scenario: [Negative] - Verify user cannot DELETE non-existing post by ID
    @Given("I set DELETE endpoint for a non-existing post")
    public void setDeleteEndpointForNonExistingPost() {
        delete.setDeleteEndpointForNonExistingPost();
    }

    @When("I send DELETE HTTP request for a non-existing post")
    public void sendDeleteHttpRequestForNonExistingPost(){
        delete.sendDeleteHttpRequestForNonExistingPost();
    }

    @Then("I receive HTTP response code 404")
    public void receiveHttpresponseCode404(){
        delete.receiveHttpresponseCode404();
    }
}



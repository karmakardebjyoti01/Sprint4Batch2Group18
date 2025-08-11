package steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import config.ApiConfig;
import utils.AuthUtil;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PassengerSteps {
    private String token;
    private Response response;

    @Given("I have a valid access token")
    public void i_have_a_valid_access_token() {
        token = AuthUtil.getAccessToken();
    }

    @When("I add passenger with id {string} name {string} mobile {string} gender {string} aadhaar {string} address {string}")
    public void addPassenger(String idVal, String name, String mobile, String gender, String aadhaar, String address) {
    	int id=Integer.parseInt(idVal);
        Map<String, String> form = new HashMap<>();
        form.put("passengerId", String.valueOf(id));
        form.put("passengerName", name);
        form.put("passengerMobile", mobile);
        form.put("passengerGender", gender);
        form.put("passengerAadhaarNumber", aadhaar);
        form.put("passengerAddress", address);

        response = given()
            .spec(ApiConfig.REQUEST)
            .auth().oauth2(token)
            .formParams(form)
        .when()
            .post("/addPassenger")
        .then()
            .extract().response();
    }

    @Then("the response status should be {string}")
    public void response_status_should_be(String status) {
        response.then().statusCode(Integer.parseInt(status));
    }
//    @Then("the response status should be {String}")
//    public void response_status_should_be_String(String status) {
//        response.then().statusCode(Integer.parseInt(status));
//    }
//    @Then("the response status should be {string}")
//    public void the_response_status_should_be(String status) {
//        // Write code here that turns the phrase above into concrete actions
//    	response.then().statusCode(Integer.parseInt(status));
//    }

    @Then("the passenger with id {string} should have name {string}")
    public void passenger_should_have_name(String id, String expectedName) {
        // fetch by id and assert name
        Response r = given()
            .spec(ApiConfig.REQUEST)
            .auth().oauth2(token)
        .when()
            .get("/viewPassengerById/" + id)
        .then()
            .statusCode(200)
            .extract().response();

        String actualName = r.jsonPath().getString("passengerName");
        assertThat(actualName, equalTo(expectedName));
    }

    @When("I fetch passenger list")
    public void fetch_passenger_list() {
        response = given().spec(ApiConfig.REQUEST).auth().oauth2(token).when().get("/viewPassengerList").then().extract().response();
    }

    @Then("the list should contain passenger id {string}")
    public void list_should_contain_id(String id) {
    	
//        assertThat(response.asString(), containsString(String.valueOf(Integer.parseInt(id))));
    	List<Integer> passengerIds = response.jsonPath().getList("passengerId");
        assertThat(passengerIds, hasItem(Integer.parseInt(id)));
    }

    @When("I fetch passenger by name {string} and mobile {string}")
    public void fetch_by_name_mobile(String name, String mobile) {
        response = given().spec(ApiConfig.REQUEST).auth().oauth2(token).when()
            .get("/viewPassengerByNameMobile/" + name + "/" + mobile).then().extract().response();
    }

    @When("I delete passenger with id {string}")
    public void delete_passenger(String id) {
        response = given().spec(ApiConfig.REQUEST).auth().oauth2(token).when().delete("/deletePassengerById/" + id).then().extract().response();
    }
    @When("I fetch passenger by id {string}")
    public void i_fetch_passenger_by_id(String id) {
        // Write code here that turns the phrase above into concrete actions
    	response = given().spec(ApiConfig.REQUEST).auth().oauth2(token).when().get("/viewPassengerById/"+id).then().extract().response();
    }
}

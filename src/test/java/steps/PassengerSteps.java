package steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import config.ApiConfig;
import utils.AuthUtil;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class PassengerSteps {
    private String token;
    private Response response;

    @Given("I have a valid access token")
    public void i_have_a_valid_access_token() {
        token = AuthUtil.getAccessToken();
    }

    @When("I add passenger with id {int} name {string} mobile {string} gender {string} aadhaar {string} address {string}")
    public void addPassenger(int id, String name, String mobile, String gender, String aadhaar, String address) {
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

    @Then("the response status should be {int}")
    public void response_status_should_be(int status) {
        response.then().statusCode(status);
    }

    @Then("the passenger with id {int} should have name {string}")
    public void passenger_should_have_name(int id, String expectedName) {
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

    @Then("the list should contain passenger id {int}")
    public void list_should_contain_id(int id) {
        assertThat(response.asString(), containsString(String.valueOf(id)));
    }

    @When("I fetch passenger by name {string} and mobile {string}")
    public void fetch_by_name_mobile(String name, String mobile) {
        response = given().spec(ApiConfig.REQUEST).auth().oauth2(token).when()
            .get("/viewPassengerByNameMobile/" + name + "/" + mobile).then().extract().response();
    }

    @When("I delete passenger with id {int}")
    public void delete_passenger(int id) {
        response = given().spec(ApiConfig.REQUEST).auth().oauth2(token).when().delete("/deletePassengerById/" + id).then().extract().response();
    }
}

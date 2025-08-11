package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AuthUtil {
    private static final String AUTH_BASE = System.getProperty("auth.base",
        "https://keycloak.tekstac.com/realms/soapdemo/protocol/openid-connect"); // from case doc
    private static final String CLIENT_ID = System.getProperty("client.id","soap-test");
    private static final String CLIENT_SECRET = System.getProperty("client.secret",
        "tE2HfYI5z4BhX7R8pimTrxzMLsueUG27"); // placeholder: from doc

    public static String getAccessToken() {
        Response r = RestAssured.given()
            .contentType("application/x-www-form-urlencoded")
            .formParam("grant_type","client_credentials")
            .formParam("client_id", CLIENT_ID)
            .formParam("client_secret", CLIENT_SECRET)
            .post(AUTH_BASE + "/token")
            .then()
            .statusCode(200)
            .extract().response();

        return r.jsonPath().getString("access_token");
    }
}

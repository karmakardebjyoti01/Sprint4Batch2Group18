package config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;

public class ApiConfig {
    public static final RequestSpecification REQUEST;

    static {
        String base = System.getProperty("api.base",
            "https://webapps.tekstac.com/TrainAPI/PassengerService"); // from case doc
        REQUEST = new RequestSpecBuilder()
                .setBaseUri(base)
                // default for addPassenger is form-url-encoded
                .setContentType("application/x-www-form-urlencoded")
                .addHeader("Accept", "application/json")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }
}

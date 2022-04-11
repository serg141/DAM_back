package Content;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specification {

    public static RequestSpecification requestSpec() {
        RestAssured.useRelaxedHTTPSValidation();
        String url = "https://dsls-content-develop.ds5-genr03-dsls-d0-dso.apps.ds5-genr03.corp.dev.vtb/v1.1/content";
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build()
                .header("x-user-session-id", "111")
                .header("x-debug", "true");
    }

    public static RequestSpecification activator() {
        RestAssured.useRelaxedHTTPSValidation();
        String url = "https://dsls-campaign-activator-develop.ds5-genr03-dsls-d0-dso.apps.ds5-genr03.corp.dev.vtb" +
                "/test/flights";
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification responseSpec200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    public static void installSpec(RequestSpecification request, ResponseSpecification response) {
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }
}

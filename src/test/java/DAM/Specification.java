package DAM;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.Data;

import static org.hamcrest.CoreMatchers.equalTo;

@Data
public class Specification {
    private String login;
    private String pass;

    static String logIn = new LogIn().logIn();

    public static RequestSpecification requestSpec() {
        String url = "http://dsls-dam-develop.ds5-genr03-dsls-d0-dso.apps.ds5-genr03.corp.dev.vtb";
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification requestSpecNew() {
        String url = "http://dsls-dam-develop.ds5-genr03-dsls-d0-dso.apps.ds5-genr03.corp.dev.vtb/campaigns/";
        return new RequestSpecBuilder()
                .setSessionId("JSESSIONID", logIn)
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification requestFlight() {
        String url = "http://dsls-dam-develop.ds5-genr03-dsls-d0-dso.apps.ds5-genr03.corp.dev.vtb/flights/";
        return new RequestSpecBuilder()
                .setSessionId("JSESSIONID", logIn)
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification requestSegmentCategories() {
        String url = "http://dsls-dam-develop.ds5-genr03-dsls-d0-dso.apps.ds5-genr03.corp.dev.vtb" +
                "/segment-categories/rootcategories";
        return new RequestSpecBuilder()
                .setSessionId("JSESSIONID", logIn)
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .addQueryParam("type", "SOCIAL")
                .build();
    }

    public static RequestSpecification requestFilter() {
        String url = "http://dsls-dam-develop.ds5-genr03-dsls-d0-dso.apps.ds5-genr03.corp.dev.vtb/campaigns/all";
        return new RequestSpecBuilder()
                .setSessionId("JSESSIONID", logIn)
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .addQueryParam("pageSize", 100)
                .addQueryParam("sortBy", "modifiedTime")
                .addQueryParam("sortDirection", "DESC")
                .build();
    }

    public static RequestSpecification requestSpecLogIn() {
        String url = "http://dsls-dam-develop.ds5-genr03-dsls-d0-dso.apps.ds5-genr03.corp.dev.vtb/campaigns/";
        return new RequestSpecBuilder()
                .setSessionId("JSESSIONID", logIn)
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification responseSpec200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    public static ResponseSpecification responseSpec401() {
        return new ResponseSpecBuilder()
                .expectStatusCode(401)
                .build();
    }

    public static ResponseSpecification responseSpec405() {
        return new ResponseSpecBuilder()
                .expectStatusCode(405)
                .build();
    }

    public static ResponseSpecification responseCreateCampaign() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .expectBody("status", equalTo("DRAFT"))
                .expectBody("createdBy", equalTo("Камынин Сергей Игоревич"))
                .build();
    }

    public static void installSpec(RequestSpecification request, ResponseSpecification response) {
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }

    public static void installSpec1(RequestSpecification request) {
        RestAssured.requestSpecification = request;
    }

    public void LogIn() {
        this.login = "vtb4040204";
        this.pass = "141523Pota#";
    }
}

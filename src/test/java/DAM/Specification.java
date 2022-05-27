package DAM;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.Data;
import org.json.JSONException;

import static org.hamcrest.CoreMatchers.equalTo;

@Data
public class Specification {
    static String logIn;

    static {
        try {
            logIn = new LogIn().getSessionId();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static RequestSpecification requestSpec() {
        RestAssured.useRelaxedHTTPSValidation();
        String url = "https://dsls-dam-develop.ds5-genr03-dsls-d0-dso.apps.ds5-genr03.corp.dev.vtb";
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification requestFlight() {
        RestAssured.useRelaxedHTTPSValidation();
        String url = "https://dsls-dam-develop.ds5-genr03-dsls-d0-dso.apps.ds5-genr03.corp.dev.vtb/flights/";
        return new RequestSpecBuilder()
                .setSessionId("JSESSIONID", logIn)
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification brief() {
        RestAssured.useRelaxedHTTPSValidation();
        String url = "https://dsls-dam-develop.ds5-genr03-dsls-d0-dso.apps.ds5-genr03.corp.dev.vtb/flights/briefs";
        return new RequestSpecBuilder()
                .setSessionId("JSESSIONID", logIn)
                .setBaseUri(url)
                .setContentType("multipart/form-data")
                .build();
    }

    public static RequestSpecification List() {
        RestAssured.useRelaxedHTTPSValidation();
        String url = "https://dsls-dam-develop.ds5-genr03-dsls-d0-dso.apps.ds5-genr03.corp.dev.vtb/lists";
        return new RequestSpecBuilder()
                .setSessionId("JSESSIONID", logIn)
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification Users() {
        RestAssured.useRelaxedHTTPSValidation();
        String url = "https://dsls-dam-develop.ds5-genr03-dsls-d0-dso.apps.ds5-genr03.corp.dev.vtb/users";
        return new RequestSpecBuilder()
                .setSessionId("JSESSIONID", logIn)
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification Teams() {
        RestAssured.useRelaxedHTTPSValidation();
        String url = "https://dsls-dam-develop.ds5-genr03-dsls-d0-dso.apps.ds5-genr03.corp.dev.vtb/teams";
        return new RequestSpecBuilder()
                .setSessionId("JSESSIONID", logIn)
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification Reactivate() {
        RestAssured.useRelaxedHTTPSValidation();
        String url = "https://dsls-dam-develop.ds5-genr03-dsls-d0-dso.apps.ds5-genr03.corp.dev.vtb" +
                "/support/flights/reactivate";
        return new RequestSpecBuilder()
                .setSessionId("JSESSIONID", logIn)
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification requestSegmentCategories() {
        RestAssured.useRelaxedHTTPSValidation();
        String url = "https://dsls-dam-develop.ds5-genr03-dsls-d0-dso.apps.ds5-genr03.corp.dev.vtb" +
                "/segment-categories/rootcategories";
        return new RequestSpecBuilder()
                .setSessionId("JSESSIONID", logIn)
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .addQueryParam("type", "SOCIAL")
                .build();
    }

    public static RequestSpecification requestFilter() {
        RestAssured.useRelaxedHTTPSValidation();
        String url = "https://dsls-dam-develop.ds5-genr03-dsls-d0-dso.apps.ds5-genr03.corp.dev.vtb/campaigns/all";
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
        RestAssured.useRelaxedHTTPSValidation();
        String url = "https://dsls-dam-develop.ds5-genr03-dsls-d0-dso.apps.ds5-genr03.corp.dev.vtb";
        return new RequestSpecBuilder()
                .setSessionId("JSESSIONID", logIn)
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification requestSpecCsv() {
        RestAssured.useRelaxedHTTPSValidation();
        String url = "https://dsls-dam-develop.ds5-genr03-dsls-d0-dso.apps.ds5-genr03.corp.dev.vtb/flights";
        return new RequestSpecBuilder()
                .setSessionId("JSESSIONID", logIn)
                .setBaseUri(url)
                .setContentType("multipart/form-data")
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
                .expectBody("errors[0].message",
                        equalTo("Не удалось выполнить вход. Проверьте логин/пароль"))
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
}

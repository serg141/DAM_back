package DAM;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LogIn {

    public String logIn() {

        Specification user = new Specification();
        user.LogIn();

        Specification.installSpec(Specification.requestSpec(), Specification.responseSpec200());

        Response response = given().body(user).when().post("/login");

        given().cookie("JSESSIONID", response.getCookie("JSESSIONID")).when().get("/me");

        return response.getSessionId();
    }
}

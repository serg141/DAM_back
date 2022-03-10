package DAM.Tests.Teams;

import DAM.Specification;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LogIn405 {
    public String logIn() {

        Specification user = new Specification();
        user.LogIn();

        Specification.installSpec1(Specification.requestSpec());

        Response response = given()
                .body(user)
                .when()
                .post("/login");

        given()
                .cookie("JSESSIONID", response.getCookie("JSESSIONID"))
                .when()
                .get("/me");

        return response.getSessionId();
    }
}
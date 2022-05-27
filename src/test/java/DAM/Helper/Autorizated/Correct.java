package DAM.Helper.Autorizated;

import DAM.LogIn;
import DAM.Parametrs.autorization.UserLogin;
import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class Correct {

    public ArrayList<String> CorrectLogIn() throws JSONException {
        ArrayList<String> user = new ArrayList<>();
        String body = new LogIn().getUser().toString();

        Specification.installSpec(Specification.requestSpec(), Specification.responseSpec200());

        Response response = given().body(body).when().post("/login");

        response = given().cookie("JSESSIONID", response.getCookie("JSESSIONID"))
                .when().get("/me").then().extract().response();

        user.add(response.path("fullName"));
        user.add(response.path("role"));
        user.add(response.path("login"));

        given().when().post("/logout");

        return user;
    }

    public String UnCorrectPass() {
        Specification.installSpec(Specification.requestSpec(), Specification.responseSpec401());

        UserLogin userLogin = new UserLogin();
        userLogin.UserLoginUnCorrectPassword();

        Response response = given().body(userLogin).when().post("/login").then().extract().response();

        return response.path("errors.message").toString();
    }

    public String UnCorrectLogin() {
        Specification.installSpec(Specification.requestSpec(), Specification.responseSpec401());

        UserLogin userLogin = new UserLogin();
        userLogin.UserLoginUnCorrectLogin();

        Response response = given().body(userLogin).when().post("/login").then().extract().response();

        return response.path("errors.message").toString();
    }
}

package DAM.Tests.Autorization;

import DAM.Parametrs.autorization.UserLogin;
import DAM.Specification;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ApiLoginSuccessTest {

    @Test
    public void LogIn() {

        UserLogin userLogin = new UserLogin();
        userLogin.UserLoginCorrect();

        Specification.installSpec(Specification.requestSpec(), Specification.responseSpec200());

        Response response = given().body(userLogin).when().post("/login");

        response = given().cookie("JSESSIONID", response.getCookie("JSESSIONID"))
            .when().get("/me").then().extract().response();

        assertEquals("Камынин Сергей Игоревич", response.path("fullName"));
        assertEquals("REDACTOR", response.path("role"));
        assertEquals("vtb4040204@corp.dev.vtb", response.path("login"));
    }
}

package DAM.Tests.Autorization;

import DAM.Specification;
import DAM.autorization.UserData;
import DAM.autorization.UserLogin;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ApiLoginSuccessTest {

    @Test
    public void LogIn() {

        UserLogin userLogin = new UserLogin();
        userLogin.UserLoginCorrect();

        Specification.installSpec(Specification.requestSpec(), Specification.responseSpec200());

        Response response = given()
                .body(userLogin)
                .when()
                .post("/login");

        UserData data = given()
            .cookie("JSESSIONID", response.getCookie("JSESSIONID"))
            .when()
            .get("/me")
            .then()
            .extract().as(UserData.class);

        assertEquals("Камынин Сергей Игоревич", data.getFullName());
        assertEquals("REDACTOR", data.getRole());
        assertEquals("vtb4040204@corp.dev.vtb", data.getLogin());
    }
}

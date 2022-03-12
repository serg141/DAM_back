package DAM.Tests.Autorization;

import DAM.EndPoints;
import DAM.Specification;
import DAM.Parametrs.autorization.UserLogin;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ApiLoginSuccessTest {
    String logIn, me;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new EndPoints().getLogin();
        me = new EndPoints().getMe();
    }

    @Test
    public void LogIn() {

        UserLogin userLogin = new UserLogin();
        userLogin.UserLoginCorrect();

        Specification.installSpec(Specification.requestSpec(), Specification.responseSpec200());

        Response response = given()
                .body(userLogin)
                .when()
                .post(logIn);

        response = given()
            .cookie("JSESSIONID", response.getCookie("JSESSIONID"))
            .when()
            .get(me)
            .then()
            .extract().response();

        assertEquals("Камынин Сергей Игоревич", response.path("fullName"));
        assertEquals("REDACTOR", response.path("role"));
        assertEquals("vtb4040204@corp.dev.vtb", response.path("login"));
    }
}

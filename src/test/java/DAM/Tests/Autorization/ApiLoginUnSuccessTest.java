package DAM.Tests.Autorization;

import DAM.Specification;
import DAM.autorization.UserLogin;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ApiLoginUnSuccessTest {
    @Test
    public void LogIn() {
        Specification.installSpec(Specification.requestSpec(), Specification.responseSpec401());

        UserLogin userLogin = new UserLogin();
        userLogin.UserLoginUnCorrectPassword();

        Response response = given()
                .body(userLogin)
                .when()
                .post("/login")
                .then()
                .extract().response();

        assertEquals("Не удалось выполнить вход. Проверьте логин/пароль", response.path("errors[0].message"));

        userLogin.UserLoginUnCorrectLogin();
        response = given()
                .body(userLogin)
                .when()
                .post("/login")
                .then()
                .extract().response();

        assertEquals("Не удалось выполнить вход. Проверьте логин/пароль", response.path("errors[0].message"));
    }
}

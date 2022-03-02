package DAM.Tests.Autorization;

import DAM.Specification;
import DAM.autorization.UserData;
import DAM.autorization.UserLogin;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class ApiLoginUnSuccessTest {

    @Test
    public void LogIn() {
        Specification.installSpec(Specification.requestSpec(), Specification.responseSpec401());

        UserLogin userLogin = new UserLogin();
        userLogin.UserLoginUnCorrectPassword();

        List<UserData> data = given()
                .body(userLogin)
                .when()
                .post("/login")
                .then()
                .extract().body().jsonPath().getList("errors", UserData.class);

        List<String> messages = data.stream().map(UserData::getMessage).collect(Collectors.toList());
        Assert.assertEquals("Не удалось выполнить вход. Проверьте логин/пароль", messages.get(0));

        userLogin.UserLoginUnCorrectLogin();
        List<UserData> dataLogin = given()
                .body(userLogin)
                .when()
                .post("/login")
                .then()
                .extract().body().jsonPath().getList("errors", UserData.class);

        messages = dataLogin.stream().map(UserData::getMessage).collect(Collectors.toList());
        Assert.assertEquals("Не удалось выполнить вход. Проверьте логин/пароль", messages.get(0));
    }
}

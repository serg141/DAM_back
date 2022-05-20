package DAM.Tests.Autorization;

import DAM.Parametrs.autorization.UserLogin;
import DAM.Specification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiLoginUnSuccessTest {
    @Test
    public void UnLogIn() {
        Specification.installSpec(Specification.requestSpec(), Specification.responseSpec401());

        UserLogin userLogin = new UserLogin();
        userLogin.UserLoginUnCorrectPassword();

        given().body(userLogin).when().post("/login");

        userLogin.UserLoginUnCorrectLogin();
        given().body(userLogin).when().post("/login");
    }
}

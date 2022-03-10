package DAM.Tests.Autorization;

import DAM.EndPoints;
import DAM.LogIn;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ApiLogOutTest {
    String logIn, logOut;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();

        logOut = new EndPoints().getLogout();
    }

    @Test
    public void postLogOutTest() {
        given()
                .cookie("JSESSIONID", logIn)
                .when()
                .post(logOut);
    }
}

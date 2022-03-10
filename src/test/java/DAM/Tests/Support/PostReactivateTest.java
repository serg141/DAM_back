package DAM.Tests.Support;

import DAM.EndPoints;
import DAM.LogIn;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostReactivateTest {
    String logIn, reactivate;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();

        reactivate = new EndPoints().getReactivate();
    }

    @Test
    public void postReactivateTest() {
        given()
                .cookie("JSESSIONID", logIn)
                .when()
                .post(reactivate);

        given()
                .cookie("JSESSIONID", logIn)
                .when()
                .get(reactivate);
    }
}

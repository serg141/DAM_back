package DAM.Tests.Filters;

import DAM.EndPoints;
import DAM.LogIn;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetUsersListTest {
    String logIn, users, list;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();

        users = new EndPoints().getUsers();
        list = new EndPoints().getList();
    }

    @Test
    public void successCreateFlightStepFiveGhostNone() {
        given()
                .cookie("JSESSIONID", logIn)
                .when()
                .get(users + list)
                .then().statusCode(200);
    }
}

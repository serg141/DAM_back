package DAM.Tests.Teams;

import DAM.EndPoints;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostUsersListTest {
    String logIn, users, list;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn405().logIn();

        users = new EndPoints().getUsers();
        list = new EndPoints().getList();
    }

    @Test
    public void getUsersList() {
        given()
                .cookie("JSESSIONID", logIn)
                .when()
                .post(users + list)
                .then().statusCode(405);
    }
}

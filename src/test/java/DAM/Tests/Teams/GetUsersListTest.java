package DAM.Tests.Teams;

import DAM.EndPoints;
import DAM.LogIn;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.assertTrue;
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
    public void getUserList() {
        Response response = given()
                .cookie("JSESSIONID", logIn)
                .when()
                .get(users + list)
                .then()
                .extract().response();

        ArrayList<String> userName = response.path("fullName");
        for(int i = 0; i <= userName.size(); i++) {
            assertTrue(userName.contains("Камынин Сергей Игоревич"));
        }
    }
}

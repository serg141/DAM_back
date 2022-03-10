package DAM.Tests.Teams;

import DAM.EndPoints;
import DAM.LogIn;
import DAM.Parametrs.Teams.UserRole;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PostUserRoleTest {
    String logIn, users, role, body, test;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();

        users = new EndPoints().getUsers();
        role = new EndPoints().getRole();
    }

    @Test
    public void postUserRoleContentManager() throws JSONException {
        body = new UserRole().getUserRoleContentManager();

        Response response = given()
                .cookie("JSESSIONID", logIn)
                .when()
                .body(body)
                .post(users + "/user2" + role)
                .then()
                .extract().response();

        assertEquals("user2", response.path("login"));
        assertEquals("test user two", response.path("fullName"));
        assertEquals("CONTENT_MANAGER", response.path("role"));
    }

    @Test
    public void postUserRoleModerator() throws JSONException {
        body = new UserRole().getUserRoleModerator();

        Response response = given()
                .cookie("JSESSIONID", logIn)
                .when()
                .body(body)
                .post(users + "/user2" + role)
                .then()
                .extract().response();

        assertEquals("user2", response.path("login"));
        assertEquals("test user two", response.path("fullName"));
        assertEquals("MODERATOR", response.path("role"));
    }

    @Test
    public void postUserRoleRedactor() throws JSONException {
        body = new UserRole().getUserRoleRedactor();

        Response response = given()
                .cookie("JSESSIONID", logIn)
                .when()
                .body(body)
                .post(users + "/user2" + role)
                .then()
                .extract().response();

        assertEquals("user2", response.path("login"));
        assertEquals("test user two", response.path("fullName"));
        assertEquals("REDACTOR", response.path("role"));
    }
}

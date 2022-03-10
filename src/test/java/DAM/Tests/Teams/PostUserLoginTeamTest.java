package DAM.Tests.Teams;

import DAM.EndPoints;
import DAM.LogIn;
import DAM.Parametrs.Teams.CreateTeam;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PostUserLoginTeamTest {
    String logIn, teams, body, id, users;
    JSONArray teamId = new JSONArray();
    JSONObject jsonObject = new JSONObject();
    LinkedHashMap<String, Object> test, placements;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();
        body = new CreateTeam().getTeam();

        teams = new EndPoints().getTeams();
        users = new EndPoints().getUsers();

        Response response = given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .when()
                .post(teams)
                .then()
                .extract().response();

        id = response.path("id");
    }

    @Test
    public void postUserRoleRedactor() throws JSONException {
        teamId.put(id);
        jsonObject.put("data", teamId);


        Response response = given()
                .cookie("JSESSIONID", logIn)
                .when()
                .body(jsonObject.toString())
                .post(users + "/user2" + teams)
                .then()
                .extract().response();

        test = response.path("teams[0]");
        placements = response.path("teams[0].placements[0]");

        assertEquals("user2", response.path("login"));
        assertEquals("test user two", response.path("fullName"));
        assertEquals("CONTENT_MANAGER", response.path("role"));
        assertEquals(id, test.get("id"));
        assertEquals("test", test.get("name"));
        assertEquals("c6535841-1989-4287-8c5e-51c30830c562", placements.get("channelId"));
        assertEquals("038edcaf-2d19-4dfa-9c09-3ed09a9f4e5a", placements.get("locationId"));
        assertEquals("89a2018f-55e8-4ac3-930e-006867a9c3ca", placements.get("positionId"));
        assertEquals("1721cf87-f07c-496a-8c29-2eb8a3cc15b0", placements.get("formatId"));
    }
}

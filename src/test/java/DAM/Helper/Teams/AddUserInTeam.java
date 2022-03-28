package DAM.Helper.Teams;

import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

@Data
public class AddUserInTeam {
    String[] team;

    public AddUserInTeam() throws JSONException {
        team = new String[8];
        String body = new DAM.Parametrs.Teams.CreateTeam().getTeam();

        Response response = given().spec(Specification.Teams()).body(body).when().post().then().extract().response();

        JSONArray teamId = new JSONArray();
        teamId.put(response.path("id"));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", teamId);

        Specification.installSpec(Specification.Users(), Specification.responseSpec200());
        response = given().when().body(jsonObject.toString()).post("/user1/teams").then().extract().response();

        team[0] = response.path("login");
        team[1] = response.path("fullName");
        team[2] = response.path("role");
        team[3] = response.path("teams[0].name");
        team[4] = response.path("teams[0].placements[0].channelId");
        team[5] = response.path("teams[0].placements[0].locationId");
        team[6] = response.path("teams[0].placements[0].positionId");
        team[7] = response.path("teams[0].placements[0].formatId");
    }
}

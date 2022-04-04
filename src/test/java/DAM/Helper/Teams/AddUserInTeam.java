package DAM.Helper.Teams;

import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class AddUserInTeam {
    ArrayList<String> team = new ArrayList<>();

    public AddUserInTeam() throws JSONException {
        String body = new DAM.Parametrs.Teams.CreateTeam().getTeam();

        Response response = given().spec(Specification.Teams()).body(body).when().post().then().extract().response();

        JSONArray teamId = new JSONArray();
        teamId.put(response.path("id"));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", teamId);

        Specification.installSpec(Specification.Users(), Specification.responseSpec200());
        response = given().when().body(jsonObject.toString()).post("/user1/teams").then().extract().response();

        team.add(response.path("login"));
        team.add(response.path("fullName"));
        team.add(response.path("role"));
        team.add(response.path("teams[0].name"));
        team.add(response.path("teams[0].placements[0].channelId"));
        team.add(response.path("teams[0].placements[0].locationId"));
        team.add(response.path("teams[0].placements[0].positionId"));
        team.add(response.path("teams[0].placements[0].formatId"));
    }
}

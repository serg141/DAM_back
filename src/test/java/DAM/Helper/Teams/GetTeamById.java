package DAM.Helper.Teams;

import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class GetTeamById {
    ArrayList<String> teamData = new ArrayList<>();

    public GetTeamById() throws JSONException {
        String id = new CreateTeam().getTeam().get(0);

        Response response = given().when().get(id).then().extract().response();

        teamData.add(response.path("name"));
        teamData.add(response.path("placements[0].channelId"));
        teamData.add(response.path("placements[0].locationId"));
        teamData.add(response.path("placements[0].positionId"));
        teamData.add(response.path("placements[0].formatId"));
    }
}

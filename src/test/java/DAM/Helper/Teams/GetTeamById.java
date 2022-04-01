package DAM.Helper.Teams;

import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

@Data
public class GetTeamById {
    String[] teamData;

    public GetTeamById() throws JSONException {
        teamData = new String[5];
        String id = new CreateTeam().getTeam()[0];

        Response response = given().when().get(id).then().extract().response();

        teamData[0] = response.path("name");
        teamData[1] = response.path("placements[0].channelId");
        teamData[2] = response.path("placements[0].locationId");
        teamData[3] = response.path("placements[0].positionId");
        teamData[4] = response.path("placements[0].formatId");
    }
}

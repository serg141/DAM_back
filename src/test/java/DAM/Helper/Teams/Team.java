package DAM.Helper.Teams;

import DAM.Parametrs.Teams.CreateTeam;
import DAM.Parametrs.Teams.EditTeam;
import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class Team {
    public Team() {
        Specification.installSpec(Specification.Teams(), Specification.responseSpec200());
    }

    public ArrayList<String> CreateTeam() throws JSONException {
        ArrayList<String> team = new ArrayList<>();
        String body = new CreateTeam().getTeam().toString();
        Response response = given().body(body).when().post().then().extract().response();

        team.add(response.path("name"));
        team.add(response.path("placements[0].channelId"));
        team.add(response.path("placements[0].locationId"));
        team.add(response.path("placements[0].positionId"));
        team.add(response.path("placements[0].formatId"));
        team.add(response.path("usersCount").toString());
        team.add(response.path("id"));

        return team;
    }

    public ArrayList<String> GetTeamById() throws JSONException {
        String id = new Team().CreateTeam().get(6);
        ArrayList<String> teamData = new ArrayList<>();

        Response response = given().when().get(id).then().extract().response();

        teamData.add(response.path("name"));
        teamData.add(response.path("placements[0].channelId"));
        teamData.add(response.path("placements[0].locationId"));
        teamData.add(response.path("placements[0].positionId"));
        teamData.add(response.path("placements[0].formatId"));
        teamData.add(response.path("id"));

        return teamData;
    }

    public String GetTeams() {
        String teamName = "";

        Response response = given().when().get().then().extract().response();
        ArrayList<String> name = response.path("content.name");

        for (String s : name) {
            if (s.equals("test")) teamName = s;
        }

        return teamName;
    }

    public String EditTeam() throws JSONException {
        String id = new Team().CreateTeam().get(6);
        String body = new EditTeam().getTeam().toString();

        Response response = given().when().body(body).put(id).then().extract().response();

        return response.path("name");
    }
}

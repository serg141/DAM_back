package DAM.Helper.Teams;

import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

@Data
public class CreateTeam {
    String[] team;

    public CreateTeam() throws JSONException {
        team = new String[2];
        Specification.installSpec(Specification.Teams(), Specification.responseSpec200());
        String body = new DAM.Parametrs.Teams.CreateTeam().getTeam();
        Response response = given().body(body).when().post().then().extract().response();

        team[0] = response.path("id");
        team[1] = response.path("name");
    }
}

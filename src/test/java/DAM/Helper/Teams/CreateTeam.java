package DAM.Helper.Teams;

import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class CreateTeam {
    ArrayList<String> team = new ArrayList<>();

    public CreateTeam() throws JSONException {
        Specification.installSpec(Specification.Teams(), Specification.responseSpec200());
        String body = new DAM.Parametrs.Teams.CreateTeam().getTeam();
        Response response = given().body(body).when().post().then().extract().response();

        team.add(response.path("id"));
        team.add(response.path("name"));
    }
}

package DAM.Helper.Teams;

import DAM.Parametrs.Teams.EditTeam;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

@Data
public class PutTeam {
    String editTeam;

    public PutTeam() throws JSONException {
        String id = new CreateTeam().getTeam()[0];
        String body = new EditTeam().getTeam();

        Response response = given().when().body(body).put(id).then().extract().response();

        editTeam = response.path("name");
    }
}

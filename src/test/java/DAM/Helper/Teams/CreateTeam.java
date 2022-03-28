package DAM.Helper.Teams;

import org.json.JSONException;

public class CreateTeam {

    public CreateTeam() throws JSONException {
        String body = new DAM.Parametrs.Teams.CreateTeam().getTeam();
        //Response response = given().spec(Specification.Teams()).body(body).when().post("/teams").
        //        then().extract().response();
    }
}

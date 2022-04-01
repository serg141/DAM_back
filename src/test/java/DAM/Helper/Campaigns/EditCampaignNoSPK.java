package DAM.Helper.Campaigns;

import DAM.Parametrs.Campaign.EditCampaignParams;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class EditCampaignNoSPK {
    private ArrayList<String> editCamp = new ArrayList<>();

    public EditCampaignNoSPK() throws JSONException {
        String body = new EditCampaignParams().getCampaignSPK();
        String id = new CreateCampaignNoSPK().getCamp().get(2);

        Response response = given().body(body).when().put(id).then().extract().response();

        editCamp.add(response.path("name"));
        editCamp.add(response.path("type"));
    }
}

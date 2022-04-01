package DAM.Helper.Campaigns;

import DAM.Parametrs.Campaign.EditCampaignParams;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class EditCampaignSPK {
    private ArrayList<String> editCamp = new ArrayList<>();

    public EditCampaignSPK() throws JSONException {
        String body = new EditCampaignParams().getCampaignNoSPK();
        String id = new CreateCampaignSPK().getCamp().get(2);

        Response response = given().body(body).when().put(id).then().extract().response();

        editCamp.add(response.path("name"));
        editCamp.add(response.path("type"));
    }
}

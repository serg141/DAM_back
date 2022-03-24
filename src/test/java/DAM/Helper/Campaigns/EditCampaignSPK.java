package DAM.Helper.Campaigns;

import DAM.Parametrs.Campaign.EditCampaignParams;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

@Data
public class EditCampaignSPK {
    String[] campaign;

    public EditCampaignSPK() throws JSONException {
        campaign = new String[2];

        String body = new EditCampaignParams().getCampaignNoSPK();
        String id = new CreateCampaignSPK().getId();

        Response response = given()
                .body(body)
                .when()
                .put(id);

        campaign[0] = response.path("name");
        campaign[1] = response.path("type");
    }
}

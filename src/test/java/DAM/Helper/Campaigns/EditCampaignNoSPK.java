package DAM.Helper.Campaigns;

import DAM.Parametrs.Campaign.EditCampaignParams;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

@Data
public class EditCampaignNoSPK {
    private String[] campaignEditToSPK;

    public EditCampaignNoSPK() throws JSONException {
        campaignEditToSPK = new String[2];

        String body = new EditCampaignParams().getCampaignSPK();
        String id = new CreateCampaignNoSPK().getId();

        Response response = given()
                .body(body)
                .when()
                .put(id)
                .then().extract().response();

        campaignEditToSPK[0] = response.path("name");
        campaignEditToSPK[1] = response.path("type");
    }

    public String[] getCampaign() {
        return campaignEditToSPK;
    }
}

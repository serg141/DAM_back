package DAM.Campaigns;

import DAM.Parametrs.Campaign.CampaignParams;
import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

@Data
public class CreateCampaignNoSPK {
    private String[] campaignNoSPK;
    private String id;

    public CreateCampaignNoSPK() throws JSONException {

        campaignNoSPK = new String[2];
        String body = new CampaignParams().getCampaignNoSPK();

        Specification.installSpec(Specification.requestSpecNew(), Specification.responseCreateCampaign());

        Response response = given()
                .body(body)
                .when()
                .post()
                .then()
                .extract().response();

        campaignNoSPK[0] = response.path("name");
        campaignNoSPK[1] = response.path("type");
        id = response.path("id");
    }
}

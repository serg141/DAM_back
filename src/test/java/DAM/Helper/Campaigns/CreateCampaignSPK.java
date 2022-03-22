package DAM.Helper.Campaigns;

import DAM.Parametrs.Campaign.CampaignParams;
import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

@Data
public class CreateCampaignSPK {
    private String[] campaignSPK;
    private String id;

    public CreateCampaignSPK() throws JSONException {

        campaignSPK = new String[2];
        String body = new CampaignParams().getCampaignSPK();

        Specification.installSpec(Specification.requestSpecNew(), Specification.responseCreateCampaign());

        Response response = given()
                .body(body)
                .when()
                .post()
                .then().log().all()
                .extract().response();

        campaignSPK[0] = response.path("name");
        campaignSPK[1] = response.path("type");
        id = response.path("id");
    }
}

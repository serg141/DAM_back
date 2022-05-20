package IntegrationTests.CreateCampaign;

import DAM.Parametrs.Campaign.CampaignParams;
import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

@Data
public class CreateCampaign {
    private String campaignId;

    public CreateCampaign() throws JSONException {
        String body = new CampaignParams().getCampaignNoSPK().toString();
        Specification.installSpec(Specification.requestSpec(), Specification.responseCreateCampaign());
        Response response = given().body(body).when().post().then().extract().response();

        campaignId = response.path("id");
    }
}

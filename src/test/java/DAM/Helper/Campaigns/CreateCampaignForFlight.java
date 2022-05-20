package DAM.Helper.Campaigns;

import DAM.Parametrs.Campaign.CampaignParams;
import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

@Data
public class CreateCampaignForFlight {
    String id, name;

    public CreateCampaignForFlight() throws JSONException {
        String body = new CampaignParams().getCampaignForFlight().toString();

        Specification.installSpec(Specification.requestSpecCampaigns(), Specification.responseCreateCampaign());

        Response response = given().body(body).when().post().then().extract().response();

        id = response.path("id");
        name = response.path("name");
    }
}

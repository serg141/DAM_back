package DAM.Helper.Campaigns;

import DAM.Parametrs.Campaign.CampaignParams;
import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class CreateCampaignSPK {
    private ArrayList<String> camp = new ArrayList<>();

    public CreateCampaignSPK() throws JSONException {
        String body = new CampaignParams().getCampaignSPK();

        Specification.installSpec(Specification.requestSpecNew(), Specification.responseCreateCampaign());

        Response response = given().body(body).when().post().then().extract().response();

        camp.add(response.path("name"));
        camp.add(response.path("type"));
        camp.add(response.path("id"));
    }
}

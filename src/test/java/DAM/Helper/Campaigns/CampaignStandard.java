package DAM.Helper.Campaigns;

import DAM.Parametrs.Campaign.CampaignParams;
import DAM.Parametrs.Campaign.EditCampaignParams;
import DAM.Specification;
import io.restassured.response.Response;
import org.json.JSONException;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class CampaignStandard {

    public CampaignStandard() {
        Specification.installSpec(Specification.requestSpecLogIn(), Specification.responseSpec200());
    }

    public ArrayList<String> CreateCampaigns() throws JSONException {
        String body = new CampaignParams().getCampaignNoSPK().toString();
        ArrayList<String> camp = new ArrayList<>();

        Response response = given().body(body).when().post("/campaigns").then().extract().response();

        camp.add(response.path("name"));
        camp.add(response.path("type"));
        camp.add(response.path("id"));

        return camp;
    }

    public ArrayList<String> EditCampaigns() throws JSONException {
        String body = new EditCampaignParams().getCampaignSPK();
        String id = new CampaignStandard().CreateCampaigns().get(2);
        ArrayList<String> editCamp = new ArrayList<>();

        given().body(body).when().put("/campaigns/" + id).then().extract().response();
        Response response = given().when().get("/campaigns/" + id).then().extract().response();

        editCamp.add(response.path("name"));
        editCamp.add(response.path("type"));

        return editCamp;
    }
}

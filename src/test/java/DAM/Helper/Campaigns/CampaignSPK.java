package DAM.Helper.Campaigns;

import DAM.Parametrs.Campaign.CampaignParams;
import DAM.Parametrs.Campaign.EditCampaignParams;
import DAM.PojoClasses.NewCampaign;
import DAM.Specification;
import io.restassured.response.Response;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class CampaignSPK {

    public CampaignSPK() {
        Specification.installSpec(Specification.requestSpecLogIn(), Specification.responseSpec200());
    }

    public ArrayList<String> CreateCampaigns() throws JSONException {
        String body = new CampaignParams().getCampaignSPK().toString();
        ArrayList<String> camp = new ArrayList<>();

        Response response = given().body(body).when().post("/campaigns").then().extract().response();

        camp.add(response.path("name"));
        camp.add(response.path("type"));
        camp.add(response.path("id"));

        return camp;
    }

    public ArrayList<String> GetCampaigns() throws JSONException {
        String id = new CampaignSPK().CreateCampaigns().get(2);
        ArrayList<String> getCamp = new ArrayList<>();

        Response response = given().when().get("/campaigns/" + id).then().extract().response();
        given().when().get("/campaigns/" + id + "/tech-report");
        given().when().get("/campaigns/" + id + "/predict").then().extract().response();

        getCamp.add(response.path("name"));
        getCamp.add(response.path("type"));

        return getCamp;
    }

    public ArrayList<String> EditCampaigns() throws JSONException {
        String body = new EditCampaignParams().getCampaignNoSPK();
        String id = new CampaignSPK().CreateCampaigns().get(2);
        ArrayList<String> editCamp = new ArrayList<>();

        given().body(body).when().put("/campaigns/" + id).then().extract().response();
        given().when().delete("/campaigns/" + id);
        Response response = given().when().get("/campaigns/" + id).then().extract().response();

        editCamp.add(response.path("name"));
        editCamp.add(response.path("type"));
        editCamp.add(response.path("status"));

        return editCamp;
    }

    public ArrayList<String> CopyCampaigns() throws JSONException {
        String id = new CampaignSPK().CreateCampaigns().get(2);
        ArrayList<String> dataCamp = new ArrayList<>();

        given().when().put("/campaigns/" + id + "/duplicate/");

        List<NewCampaign> data = given().spec(Specification.requestFilter()).when().post().then()
                .extract().body().jsonPath().getList("content", NewCampaign.class);

        List<String> names = data.stream().map(NewCampaign::getName).collect(Collectors.toList());
        List<String> statuses = data.stream().map(NewCampaign::getStatus).collect(Collectors.toList());

        dataCamp.add(names.get(0));
        dataCamp.add(statuses.get(0));

        return dataCamp;
    }
}

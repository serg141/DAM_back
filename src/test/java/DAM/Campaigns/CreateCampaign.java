package DAM.Campaigns;

import DAM.LogIn;
import DAM.Parametrs.Campaign.CampaignParams;
import io.restassured.response.Response;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

public class CreateCampaign {
    String id;

    public CreateCampaign() throws JSONException {
        String logIn = new LogIn().logIn();
        String body = new CampaignParams().getCampaignNoSPK();

        Response response = given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .when()
                .post("/campaigns")
                .then().extract().response();
        id = response.path("id");
    }

    public String getId() {
        return id;
    }
}

package DAM.Tests.Campaign;

import DAM.Campaigns.CreateCampaign;
import DAM.EndPoints;
import DAM.LogIn;
import DAM.Parametrs.Campaign.EditCampaignParams;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PredictCampaignTest {
    String logIn, body, endpoint, predict;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();
        endpoint = new EndPoints().getCampaigns();
        body = new EditCampaignParams().getCampaignNoSPK();
        predict = new EndPoints().getPredict();
    }

    @Test
    public void deleteCampaign() throws JSONException {
        CreateCampaign campaign = new CreateCampaign();

        given()
                .cookie("JSESSIONID", logIn)
                .when()
                .get(endpoint + campaign.getId() + predict)
                .then().statusCode(200)
                .extract().response();
    }
}
package DAM.Tests.Campaign;

import DAM.Campaigns.CreateCampaign;
import DAM.EndPoints;
import DAM.LogIn;
import DAM.Parametrs.Campaign.EditCampaignParams;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class EditCampaignSPKTest {
    String logIn, duplicate, endpoint, body;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();
        duplicate = new EndPoints().getDuplicate();
        endpoint = new EndPoints().getCampaigns();
        body = new EditCampaignParams().getCampaignSPK();
    }

    @Test
    public void putCampaignsSPK() throws JSONException {
        CreateCampaign campaign = new CreateCampaign();

        Response response = given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .when()
                .put(endpoint + campaign.getId())
                .then()
                .extract().response();

        assertEquals("CampaignSPKEdit", response.path("name"));
        assertEquals("50", response.path("priority").toString());
        assertEquals("SPK", response.path("type"));
    }
}

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

public class EditCampaignTest {
    String logIn, body, campaigns;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();
        campaigns = new EndPoints().getCampaigns();
        body = new EditCampaignParams().getCampaignNoSPK();
    }

    @Test
    public void putCampaigns() throws JSONException {
        CreateCampaign campaign = new CreateCampaign();

        Response response = given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .when()
                .put(campaigns + campaign.getId())
                .then()
                .extract().response();

        int priority = response.path("priority");
        assertEquals("CampaignEdit", response.path("name"));
        assertEquals(50, priority);
    }
}

package DAM.Tests.Campaign;

import DAM.Campaigns.CreateCampaign;
import DAM.EndPoints;
import DAM.LogIn;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class DeleteCampaignTest {
    String logIn;
    String campaigns;

    @Before
    public void getEndpoint() {
        logIn = new LogIn().logIn();
        campaigns = new EndPoints().getCampaigns();
    }

    @Test
    public void deleteCampaign() throws JSONException {
        CreateCampaign campaign = new CreateCampaign();

        Response response = given()
                .cookie("JSESSIONID", logIn)
                .when()
                .delete(campaigns + campaign.getId())
                .then()
                .extract().response();

        assertEquals("REMOVED", response.path("status"));
    }
}
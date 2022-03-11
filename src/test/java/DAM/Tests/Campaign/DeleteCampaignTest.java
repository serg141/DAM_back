package DAM.Tests.Campaign;

import DAM.Campaigns.CreateCampaignForFlight;
import DAM.EndPoints;
import DAM.LogIn;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class DeleteCampaignTest {
    String logIn, campaigns, campaignId;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();
        campaignId = new CreateCampaignForFlight().getId();

        campaigns = new EndPoints().getCampaigns();
    }

    @Test
    public void getTechReport() {
        given()
                .cookie("JSESSIONID", logIn)
                .when()
                .delete(campaigns + campaignId);

        Response response = given()
                .cookie("JSESSIONID", logIn)
                .when()
                .get(campaigns + campaignId)
                .then()
                .extract().response();

        assertEquals("REMOVED", response.path("status"));
    }
}

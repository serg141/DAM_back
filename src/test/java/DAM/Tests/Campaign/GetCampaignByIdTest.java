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


public class GetCampaignByIdTest {
    String logIn, campaigns;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();
        campaigns = new EndPoints().getCampaigns();
    }

    @Test
    public void getCampaignsById() throws JSONException {
        CreateCampaign campaign = new CreateCampaign();

        Response response = given()
                .cookie("JSESSIONID", logIn)
                .when()
                .get(campaigns + campaign.getId())
                .then()
                .extract().response();

        int priority = response.path("priority");

        assertEquals("CampaignTest", response.path("name"));
        assertEquals("STANDARD", response.path("type"));
        assertEquals("DRAFT", response.path("status"));
        assertEquals("Камынин Сергей Игоревич", response.path("createdBy"));
        assertEquals(40, priority);
    }
}

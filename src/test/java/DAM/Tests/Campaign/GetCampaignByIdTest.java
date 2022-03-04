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


public class GetCampaignByIdTest {
    String logIn, body, endpoint;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();
        endpoint = new EndPoints().getCampaigns();
        body = new EditCampaignParams().getCampaignNoSPK();
    }

    @Test
    public void getCampaigns() throws JSONException {
        CreateCampaign campaign = new CreateCampaign();

        Response response = given()
                .cookie("JSESSIONID", logIn)
                .when()
                .get(endpoint + campaign.getId())
                .then().statusCode(200)
                .extract().response();

        int priority = response.path("priority");

        assertEquals("CampaignTest", response.path("name"));
        assertEquals("STANDARD", response.path("type"));
        assertEquals("DRAFT", response.path("status"));
        assertEquals("Камынин Сергей Игоревич", response.path("createdBy"));
        assertEquals(40, priority);
    }
}

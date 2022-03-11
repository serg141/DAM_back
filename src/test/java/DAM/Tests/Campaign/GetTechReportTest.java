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

public class GetTechReportTest {
    String logIn, campaigns, campaignId, techReport;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();
        campaignId = new CreateCampaignForFlight().getId();

        campaigns = new EndPoints().getCampaigns();
        techReport = new EndPoints().getTechReport();
    }

    @Test
    public void getTechReport() {
        Response response = given()
                .cookie("JSESSIONID", logIn)
                .when()
                .get(campaigns + campaignId + techReport)
                .then()
                .extract().response();

        Integer i = 0;
        assertEquals("circle", response.path("items[0].chartType"));
        assertEquals(i, response.path("items[0].order"));
        assertEquals("Каналы", response.path("items[0].title"));
    }
}

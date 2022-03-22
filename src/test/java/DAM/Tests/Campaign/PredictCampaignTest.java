package DAM.Tests.Campaign;

import DAM.Helper.Campaigns.GetCampaignById;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PredictCampaignTest {
    String[] id;

    @Before
    public void getEndpoint() throws JSONException {
        id = new GetCampaignById().getCampaign();
    }

    @Test
    public void getPredictCampaign() {
        given()
                .when()
                .get(id[2]);
    }
}
package DAM.Tests.Campaign;

import DAM.Helper.Campaigns.GetCampaignById;
import org.json.JSONException;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PredictCampaignTest {

    @Test
    public void getPredictCampaign() throws JSONException {
        String id = new GetCampaignById().getGetCamp().get(2);
        given().when().get(id);
    }
}
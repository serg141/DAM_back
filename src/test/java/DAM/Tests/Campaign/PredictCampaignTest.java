package DAM.Tests.Campaign;

import DAM.EndPoints;
import DAM.LogIn;
import org.json.JSONException;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PredictCampaignTest {

    @Test
    public void deleteCampaign() throws JSONException {
        String logIn = new LogIn().logIn();
        String endpoint = new EndPoints().getCampaigns();
        String predict = new EndPoints().getPredict();
        CreateCampaignTest campaign = new CreateCampaignTest();
        campaign.successCreate();

        given()
                .cookie("JSESSIONID", logIn)
                .when()
                .get(endpoint + campaign.getId() + predict)
                .then()
                .statusCode(200);
    }
}
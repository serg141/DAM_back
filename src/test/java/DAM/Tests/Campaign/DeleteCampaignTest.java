package DAM.Tests.Campaign;

import DAM.EndPoints;
import DAM.LogIn;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class DeleteCampaignTest {

    @Test
    public void deleteCampaign() throws JSONException {
        String logIn = new LogIn().logIn();
        String endpoint = new EndPoints().getCampaigns();
        CreateCampaignTest campaign = new CreateCampaignTest();
        campaign.successCreate();

        Response response = given()
                .cookie("JSESSIONID", logIn)
                .when()
                .delete(endpoint + campaign.getId())
                .then()
                .extract().response();

        assertEquals("REMOVED", response.path("status"));
    }
}
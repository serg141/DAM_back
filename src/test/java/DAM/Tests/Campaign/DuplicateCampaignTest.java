package DAM.Tests.Campaign;

import DAM.Campaigns.CreateCampaign;
import DAM.Campaigns.NewCampaign;
import DAM.EndPoints;
import DAM.LogIn;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class DuplicateCampaignTest {
    String logIn, duplicate, endpoint;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();
        duplicate = new EndPoints().getDuplicate();
        endpoint = new EndPoints().getCampaigns();
    }

    @Test
    public void duplicateCampaigns() throws JSONException {
        CreateCampaign campaign = new CreateCampaign();

        given()
                .cookie("JSESSIONID", logIn)
                .when()
                .put(endpoint + campaign.getId() + duplicate)
                .then()
                .statusCode(200);

        List<NewCampaign> data = given()
                .cookie("JSESSIONID", logIn)
                .when()
                .get(endpoint)
                .then()
                .extract().body().jsonPath().getList("Content", NewCampaign.class);

        List<String> name = data.stream().map(NewCampaign::getName).collect(Collectors.toList());

        for (String copyName : name) {
            assertEquals("copy_CampaignTest", copyName);
        }
    }
}

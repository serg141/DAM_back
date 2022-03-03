package DAM.Tests.Campaign;

import DAM.Campaigns.CreateCampaign;
import DAM.Campaigns.NewCampaign;
import DAM.EndPoints;
import DAM.LogIn;
import DAM.Parametrs.Campaign.EditCampaignParams;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class GetCampaignsTest {
    String createCampaignId, logIn, body, endpoint;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();
        endpoint = new EndPoints().getCampaigns();
        body = new EditCampaignParams().getCampaignNoSPK();
    }

    @Test
    public void getCampaigns() throws JSONException {
        CreateCampaign campaign = new CreateCampaign();

        createCampaignId = campaign.getId();

        List<NewCampaign> data = given()
                .cookie("JSESSIONID", logIn)
                .when()
                .get(endpoint)
                .then()
                .extract().body().jsonPath().getList("Content", NewCampaign.class);

        List<String> id = data.stream().map(NewCampaign::getId).collect(Collectors.toList());
        List<String> name = data.stream().map(NewCampaign::getName).collect(Collectors.toList());
        List<String> status = data.stream().map(NewCampaign::getStatus).collect(Collectors.toList());
        List<String> type = data.stream().map(NewCampaign::getType).collect(Collectors.toList());
        List<String> createdBy = data.stream().map(NewCampaign::getCreatedBy).collect(Collectors.toList());

        for (int i = 0; i < id.size(); i++) {
            assertTrue(id.get(i).contains(createCampaignId)); {
                assertEquals("CampaignTest", name.get(i));
                assertEquals("DRAFT", status.get(i));
                assertEquals("STANDARD", type.get(i));
                assertEquals("Камынин Сергей Игоревич", createdBy.get(i));
            }
        }
    }
}

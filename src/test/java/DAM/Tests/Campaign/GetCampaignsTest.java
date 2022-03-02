package DAM.Tests.Campaign;

import DAM.Campaigns.NewCampaign;
import DAM.EndPoints;
import DAM.LogIn;
import org.json.JSONException;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class GetCampaignsTest {
    String createCampaignId;

    @Test
    public void getCampaigns() throws JSONException {
        String logIn = new LogIn().logIn();
        String endpoint = new EndPoints().getCampaigns();
        CreateCampaignTest campaign = new CreateCampaignTest();
        campaign.successCreate();

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

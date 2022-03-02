package DAM.Tests.Campaign;

import DAM.Campaigns.NewCampaign;
import DAM.EndPoints;
import DAM.LogIn;
import lombok.Data;
import org.json.JSONException;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

@Data
public class DuplicateCampaignTest {

    @Test
    public void duplicateCampaigns() throws JSONException {
        String logIn = new LogIn().logIn();
        String endpoint = new EndPoints().getCampaigns();
        String duplicate = new EndPoints().getDuplicate();

        CreateCampaignTest campaign = new CreateCampaignTest();
        campaign.successCreate();

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

        for (int i = 0; i < name.size(); i++) {
            assertEquals("copy_CampaignTest", name.get(i));
        }
    }
}

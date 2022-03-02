package DAM.Tests.Campaign;

import DAM.EndPoints;
import DAM.LogIn;
import DAM.Parametrs.EditCampaignParams;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

@Data
public class EditCampaignTest {

    @Test
    public void putCampaigns() throws JSONException {
        String logIn = new LogIn().logIn();
        String endpoint = new EndPoints().getCampaigns();
        CreateCampaignTest campaign = new CreateCampaignTest();
        String body = new EditCampaignParams().getCampaignNoSPK();
        campaign.successCreate();

        Response response = given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .when()
                .put(endpoint + campaign.getId())
                .then()
                .extract().response();

        assertEquals("CampaignEdit", response.path("name"));
        assertEquals("50", response.path("priority").toString());
    }
}

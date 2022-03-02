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
public class EditCampaignSPKTest {

    @Test
    public void putCampaignsSPK() throws JSONException {
        String logIn = new LogIn().logIn();
        String endpoint = new EndPoints().getCampaigns();
        CreateCampaignSPKTest campaign = new CreateCampaignSPKTest();
        String body = new EditCampaignParams().getCampaignSPK();
        campaign.successCreate();

        Response response = given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .when()
                .put(endpoint + campaign.getId())
                .then()
                .extract().response();

        assertEquals("CampaignSPKEdit", response.path("name"));
        assertEquals("50", response.path("priority").toString());
        assertEquals("SPK", response.path("type"));
    }
}

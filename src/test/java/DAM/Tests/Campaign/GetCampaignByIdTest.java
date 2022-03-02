package DAM.Tests.Campaign;

import DAM.EndPoints;
import DAM.LogIn;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class GetCampaignByIdTest {

    @Test
    public void getCampaigns() throws JSONException {
        String logIn = new LogIn().logIn();
        String endpoint = new EndPoints().getCampaigns();
        CreateCampaignTest campaign = new CreateCampaignTest();
        campaign.successCreate();

        Response response = given()
                .cookie("JSESSIONID", logIn)
                .when()
                .get(endpoint + campaign.getId())
                .then()
                .extract().response();

        assertEquals("CampaignTest", response.path("name"));
        assertEquals("STANDARD", response.path("type"));
        assertEquals("DRAFT", response.path("status"));
        assertEquals("Камынин Сергей Игоревич", response.path("createdBy"));
        assertEquals("40", response.path("priority").toString());
    }
}

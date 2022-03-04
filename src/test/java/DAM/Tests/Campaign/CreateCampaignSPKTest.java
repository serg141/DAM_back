package DAM.Tests.Campaign;

import DAM.EndPoints;
import DAM.LogIn;
import DAM.Parametrs.Campaign.CampaignParams;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class CreateCampaignSPKTest {
    String id, logIn, body, endpoint;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();
        body = new CampaignParams().getCampaignSPK();
        endpoint = new EndPoints().getCampaigns();
    }

    @Test
    public void successCreate() {
        Response response = given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .when()
                .post(endpoint)
                .then().statusCode(200)
                .extract().response();
        id = response.path("id");

        assertEquals("CampaignSPK", response.path("name"));
        assertEquals("SPK", response.path("type"));
        assertEquals("DRAFT", response.path("status"));
        assertEquals("Камынин Сергей Игоревич", response.path("createdBy"));
        assertEquals("40", response.path("priority").toString());
    }
}

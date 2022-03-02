package DAM.Tests.Campaign;

import DAM.EndPoints;
import DAM.LogIn;
import DAM.Parametrs.CampaignParams;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

@Data
public class CreateCampaignSPKTest {
    String id;

    @Test
    public void successCreate() throws JSONException {
        String logIn = new LogIn().logIn();
        String body = new CampaignParams().getCampaignSPK();
        String endpoint = new EndPoints().getCampaigns();

        Response response = given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .when()
                .post(endpoint)
                .then().extract().response();
        id = response.path("id");

        assertEquals("CampaignSPK", response.path("name"));
        assertEquals("SPK", response.path("type"));
        assertEquals("DRAFT", response.path("status"));
        assertEquals("Камынин Сергей Игоревич", response.path("createdBy"));
        assertEquals("40", response.path("priority").toString());
    }
}

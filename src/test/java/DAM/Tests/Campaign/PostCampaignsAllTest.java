package DAM.Tests.Campaign;

import DAM.EndPoints;
import DAM.LogIn;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class PostCampaignsAllTest {
    String campaigns, logIn;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();
        campaigns = new EndPoints().getCampaigns();
    }

    @Test
    public void postCampaignsAll() {
        given()
                .cookie("JSESSIONID", logIn)
                .queryParam("pageSize", 100)
                .queryParam("sortBy", "modifiedTime")
                .queryParam("sortDirection", "DESC")
                .when()
                .post(campaigns + "all");
    }
}

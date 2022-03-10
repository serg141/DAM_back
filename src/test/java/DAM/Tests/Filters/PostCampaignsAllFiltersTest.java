package DAM.Tests.Filters;

import DAM.Campaigns.Content;
import DAM.EndPoints;
import DAM.LogIn;
import DAM.Parametrs.Filters.FiltersParams;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class PostCampaignsAllFiltersTest {
    String campaigns, logIn, body;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();
        campaigns = new EndPoints().getCampaigns();
        body = new FiltersParams().getFilter();
    }

    @Test
    public void postCampaignsAll() {
        List<Content> data = given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .when()
                .post(campaigns + "all")
                .then()
                .extract().body().jsonPath().getList("content", Content.class);

        List<String> status = data.stream().map(Content::getStatus).collect(Collectors.toList());
        List<String> name = data.stream().map(Content::getName).collect(Collectors.toList());
        for (String s : name) {
            assertTrue(s.contains("Campaign"));
            assertTrue(!status.contains("DRAFT") & !status.contains("REMOVED"));
        }
    }
}

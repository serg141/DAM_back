package DAM.Tests.Filters;

import DAM.PojoClasses.AllCampaignsByCreatorId;
import DAM.EndPoints;
import DAM.LogIn;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class PostCampaignsAllCreatorIdsTest {
    String campaigns, logIn, id, me;
    JSONArray creatorIds = new JSONArray();
    JSONObject jsonObject = new JSONObject();

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();
        campaigns = new EndPoints().getCampaigns();
        me = new EndPoints().getMe();

        Response response = given()
                .cookie("JSESSIONID", logIn)
                .when()
                .get(me)
                .then()
                .extract().response();

        id = response.path("id");
    }

    @Test
    public void postCampaignsAll() throws JSONException {
        creatorIds.put(id);
        jsonObject.put("creatorIds", creatorIds);
        List<AllCampaignsByCreatorId> content = given()
                .cookie("JSESSIONID", logIn)
                .queryParam("pageSize", 100)
                .queryParam("sortBy", "modifiedTime")
                .queryParam("sortDirection", "DESC")
                .body(jsonObject.toString())
                .when()
                .post(campaigns + "all")
                .then()
                .extract().body().jsonPath().getList("content", AllCampaignsByCreatorId.class);

        List<String> createdBy = content.stream().map(AllCampaignsByCreatorId::getCreatedBy).
                collect(Collectors.toList());
        for (String s : createdBy) {
            assertTrue(s.contains("Камынин Сергей Игоревич"));
        }
    }
}

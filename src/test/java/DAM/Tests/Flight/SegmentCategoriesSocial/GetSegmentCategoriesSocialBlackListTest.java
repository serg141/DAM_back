package DAM.Tests.Flight.SegmentCategoriesSocial;

import DAM.EndPoints;
import DAM.LogIn;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetSegmentCategoriesSocialBlackListTest {
    String logIn, segmentCategories;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();
        segmentCategories = new EndPoints().getSegmentCategories();
    }

    @Test
    public void getSegmentCategoriesSocial() {
        Response response = given()
                .cookie("JSESSIONID", logIn)
                .queryParam("type", "SOCIAL")
                .when()
                .get(segmentCategories)
                .then()
                .extract().response();

        LinkedHashMap<String,Object> blackList = response.path("BLACKLIST[0]");

        LinkedHashMap<String,Object> segmentBlackList = response.path("BLACKLIST[0].segments[0]");

        assertEquals("BLACKLIST", blackList.get("code"));
        assertEquals("Исключающие сегменты", blackList.get("name"));
        assertEquals("Исключающие сегменты", blackList.get("description"));
        assertEquals("SOCIAL", blackList.get("type"));
        assertEquals("BLACKLIST", blackList.get("subtype"));

        assertEquals("BLACKLIST", segmentBlackList.get("code"));
        assertEquals("Блэк-лист", segmentBlackList.get("name"));
        assertEquals("блэк-лист", segmentBlackList.get("description"));
    }
}

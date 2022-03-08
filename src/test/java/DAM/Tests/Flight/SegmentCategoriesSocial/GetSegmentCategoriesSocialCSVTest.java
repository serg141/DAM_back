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

public class GetSegmentCategoriesSocialCSVTest {
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
                .then().statusCode(200)
                .extract().response();

        LinkedHashMap<String,Object> csv = response.path("CSV[0]");

        assertEquals("CSV", csv.get("code"));
        assertEquals("CSV", csv.get("name"));
        assertEquals("SOCIAL", csv.get("type"));
        assertEquals("CSV", csv.get("subtype"));
    }
}

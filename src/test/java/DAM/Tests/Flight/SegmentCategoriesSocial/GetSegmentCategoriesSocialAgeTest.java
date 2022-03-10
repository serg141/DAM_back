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

public class GetSegmentCategoriesSocialAgeTest {
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

        LinkedHashMap<String,Object> age = response.path("AGE[0]");

        assertEquals("AGE", age.get("code"));
        assertEquals("Возраст", age.get("name"));
        assertEquals("Возраст клиента", age.get("description"));
        assertEquals("SOCIAL", age.get("type"));
        assertEquals("AGE", age.get("subtype"));
    }
}

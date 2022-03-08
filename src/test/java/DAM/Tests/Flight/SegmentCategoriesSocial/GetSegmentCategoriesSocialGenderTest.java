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

public class GetSegmentCategoriesSocialGenderTest {
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

        LinkedHashMap<String,Object> clientType = response.path("GENDER[0]");

        LinkedHashMap<String,Object> segmentFemale = response.path("GENDER[0].segments[1]");
        LinkedHashMap<String,Object> segmentMale = response.path("GENDER[0].segments[0]");

        assertEquals("GENDER", clientType.get("code"));
        assertEquals("Пол", clientType.get("name"));
        assertEquals("Пол клиента", clientType.get("description"));
        assertEquals("SOCIAL", clientType.get("type"));
        assertEquals("GENDER", clientType.get("subtype"));

        assertEquals("FEMALE", segmentFemale.get("code"));
        assertEquals("Женский", segmentFemale.get("name"));
        assertEquals("пол", segmentFemale.get("description"));

        assertEquals("MALE", segmentMale.get("code"));
        assertEquals("Мужской", segmentMale.get("name"));
        assertEquals("пол", segmentMale.get("description"));
    }
}

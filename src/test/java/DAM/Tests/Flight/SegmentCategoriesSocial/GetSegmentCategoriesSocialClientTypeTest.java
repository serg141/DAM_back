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

public class GetSegmentCategoriesSocialClientTypeTest {
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

        LinkedHashMap<String,Object> clientType = response.path("CLIENTTYPE[0]");

        LinkedHashMap<String,Object> segmentPrime = response.path("CLIENTTYPE[0].segments[2]");
        LinkedHashMap<String,Object> segmentPrivilege = response.path("CLIENTTYPE[0].segments[1]");
        LinkedHashMap<String,Object> segmentMass = response.path("CLIENTTYPE[0].segments[0]");

        assertEquals("CLIENTTYPE", clientType.get("code"));
        assertEquals("Клиентский сегмент", clientType.get("name"));
        assertEquals("Сегмент клиентов", clientType.get("description"));
        assertEquals("SOCIAL", clientType.get("type"));
        assertEquals("CLIENTTYPE", clientType.get("subtype"));

        assertEquals("PRIME", segmentPrime.get("code"));
        assertEquals("Прайм", segmentPrime.get("name"));
        assertEquals("клиентский сегмент", segmentPrime.get("description"));

        assertEquals("PRIVILEGE", segmentPrivilege.get("code"));
        assertEquals("Привилегия", segmentPrivilege.get("name"));
        assertEquals("клиентский сегмент", segmentPrivilege.get("description"));

        assertEquals("MASS", segmentMass.get("code"));
        assertEquals("Массовый", segmentMass.get("name"));
        assertEquals("клиентский сегмент", segmentMass.get("description"));
    }
}

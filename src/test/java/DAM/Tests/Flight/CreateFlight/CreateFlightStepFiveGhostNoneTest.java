package DAM.Tests.Flight.CreateFlight;

import DAM.EndPoints;
import DAM.Flights.GetPlacementId;
import DAM.LogIn;
import DAM.Parametrs.Flights.CreateFlightStepFiveGhost;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class CreateFlightStepFiveGhostNoneTest {
    String logIn, flights, id, creative, body, placementId;
    String[] ids;
    LinkedHashMap<String, Object> test;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();
        body = new CreateFlightStepFiveGhost().getFlightHideableTypeNone();

        ids = new GetPlacementId().getId();
        id = ids[0];
        placementId = ids[1];

        flights = new EndPoints().getFlights();
        creative = new EndPoints().getCreative();
        test = new EndPoints().getTest();
    }

    @Test
    public void successCreateFlightStepFiveGhostNone() {
        Response response = given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .queryParam("placementId", placementId)
                .when()
                .post(flights + id + creative)
                .then()
                .extract().response();

        test = response.path("pages[0]");
        assertEquals(1, test.get("page"));
        assertEquals("1", test.get("pageName"));
        assertEquals(false, test.get("showCross"));
        assertEquals("NONE", test.get("hideableType"));

        test = response.path("pages[0].elements[0]");
        assertEquals("https://core-cms-backend.dso-core.apps.d0-oscp.corp.dev.vtb/projects/dam/files/597733151_33.png",
                test.get("url"));
        assertEquals("image", test.get("elementId"));
        assertEquals("IMAGE", test.get("type"));
        assertEquals("2", response.path("pages[0].elements[0].link.linkAddress"));
        assertEquals("INTERNAL", response.path("pages[0].elements[0].link.linkType"));

        test = response.path("pages[0].elements[1]");
        assertEquals("Заголовок", test.get("value"));
        assertEquals("heading", test.get("elementId"));
        assertEquals("TEXT", test.get("type"));

        test = response.path("pages[0].elements[2]");
        assertEquals("Описание", test.get("value"));
        assertEquals("description", test.get("elementId"));
        assertEquals("TEXT", test.get("type"));

        test = response.path("pages[0].elements[3]");
        assertEquals("body", test.get("elementId"));
        assertEquals("BLOCK", test.get("type"));
        assertEquals("2", response.path("pages[0].elements[3].link.linkAddress"));
        assertEquals("INTERNAL", response.path("pages[0].elements[3].link.linkType"));
        assertEquals("TIFFANY", response.path("pages[0].elements[3].style.code"));
        assertEquals("#00BCD4", response.path("pages[0].elements[3].style.backGroundColor"));
        assertEquals("#FFFFFF", response.path("pages[0].elements[3].style.fontColor"));

        assertEquals("Creative", response.path("name"));
        assertEquals("LIGHT_THEME", response.path("theme"));
        assertEquals("", response.path("offerType"));
        assertEquals(false, response.path("deleted"));
    }
}

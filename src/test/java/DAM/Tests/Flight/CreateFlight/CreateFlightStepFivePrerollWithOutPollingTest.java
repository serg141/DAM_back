package DAM.Tests.Flight.CreateFlight;

import DAM.EndPoints;
import DAM.Flights.GetPlacementId;
import DAM.LogIn;
import DAM.Parametrs.Flights.CreateFlightStepFivePreroll;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class CreateFlightStepFivePrerollWithOutPollingTest {
    String logIn, flights, id, creative, body, placementId;
    String[] ids;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();
        body = new CreateFlightStepFivePreroll().getFlightHideableTypeWithOutPolling();

        ids = new GetPlacementId().getId();
        id = ids[0];
        placementId = ids[1];

        flights = new EndPoints().getFlights();
        creative = new EndPoints().getCreative();
    }

    @Test
    public void successCreateFlightStepFivePrerollWithOutPolling() {
        Response response = given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .queryParam("placementId", placementId)
                .when()
                .post(flights + id + creative)
                .then()
                .extract().response();

        LinkedHashMap<String,Object> pages = response.path("pages[0]");
        LinkedHashMap<String,Object> elementImage = response.path("pages[0].elements[0]");
        LinkedHashMap<String,Object> elementHeading = response.path("pages[0].elements[1]");
        LinkedHashMap<String,Object> elementDescription = response.path("pages[0].elements[2]");
        LinkedHashMap<String,Object> elementButton = response.path("pages[0].elements[3]");

        assertEquals(1, pages.get("page"));
        assertEquals("1", pages.get("pageName"));
        assertEquals(true, pages.get("showCross"));
        assertEquals("CROSS_WITHOUT_POLLING", pages.get("hideableType"));

        assertEquals("https://core-cms-backend.dso-core.apps.d0-oscp.corp.dev.vtb/projects/dam/files/597733151_33.png",
                elementImage.get("url"));
        assertEquals("preroll-image", elementImage.get("elementId"));
        assertEquals("IMAGE", elementImage.get("type"));
        assertEquals("Https:www.vtb.ru", response.path("pages[0].elements[0].link.linkAddress"));
        assertEquals("EXTERNAL", response.path("pages[0].elements[0].link.linkType"));

        assertEquals("Заголовок", elementHeading.get("value"));
        assertEquals("preroll-heading", elementHeading.get("elementId"));
        assertEquals("TEXT", elementHeading.get("type"));

        assertEquals("Описание", elementDescription.get("value"));
        assertEquals("preroll-description", elementDescription.get("elementId"));
        assertEquals("TEXT", elementDescription.get("type"));

        assertEquals("Кнопка", elementButton.get("value"));
        assertEquals("preroll-button", elementButton.get("elementId"));
        assertEquals("BUTTON", elementButton.get("type"));
        assertEquals("Https:www.vtb.ru", response.path("pages[0].elements[3].link.linkAddress"));
        assertEquals("EXTERNAL", response.path("pages[0].elements[3].link.linkType"));

        assertEquals("Creative", response.path("name"));
        assertEquals("LIGHT_THEME", response.path("theme"));
        assertEquals("", response.path("offerType"));
        assertEquals(false, response.path("deleted"));
    }
}

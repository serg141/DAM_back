package DAM.Tests.Flight.CreateFlight;

import DAM.EndPoints;
import DAM.Flights.GetPlacementId;
import DAM.LogIn;
import DAM.Parametrs.Flights.CreateFlightStepFiveSlider;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class CreateFlightStepFiveSliderWithOutPollingTest {
    String logIn, flights, id, creative, body, placementId;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();
        id = new GetPlacementId().getId();
        flights = new EndPoints().getFlights();
        creative = new EndPoints().getCreative();
        body = new CreateFlightStepFiveSlider().getFlightHideableTypeWithOutPolling();
        placementId = new GetPlacementId().getPlacementId();
    }

    @Test
    public void successCreateFlightStepFiveSliderWithOutPolling() {
        Response response = given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .queryParam("placementId", placementId)
                .when()
                .post(flights + id + creative)
                .then().statusCode(200)
                .extract().response();

        LinkedHashMap<String,Object> pages = response.path("pages[0]");
        LinkedHashMap<String,Object> elementHeading = response.path("pages[0].elements[0]");
        LinkedHashMap<String,Object> elementDescription = response.path("pages[0].elements[1]");
        LinkedHashMap<String,Object> elementBlock = response.path("pages[0].elements[2]");
        LinkedHashMap<String,Object> elementLabelBody = response.path("pages[0].elements[3]");
        LinkedHashMap<String,Object> elementLabelText = response.path("pages[0].elements[4]");
        LinkedHashMap<String,Object> elementButton = response.path("pages[0].elements[5]");

        assertEquals(1, pages.get("page"));
        assertEquals("1", pages.get("pageName"));
        assertEquals("772c92df-96aa-4527-a015-0e64d53cca1f", pages.get("templateId"));
        assertEquals(true, pages.get("showCross"));
        assertEquals("CROSS_WITHOUT_POLLING", pages.get("hideableType"));

        assertEquals("Заголовок", elementHeading.get("value"));
        assertEquals("heading", elementHeading.get("elementId"));
        assertEquals("TEXT", elementHeading.get("type"));

        assertEquals("Описание", elementDescription.get("value"));
        assertEquals("description", elementDescription.get("elementId"));
        assertEquals("TEXT", elementDescription.get("type"));

        assertEquals("body", elementBlock.get("elementId"));
        assertEquals("BLOCK", elementBlock.get("type"));
        assertEquals("FUCHSIA", response.path("pages[0].elements[2].style.code"));
        assertEquals("#F86D86", response.path("pages[0].elements[2].style.backGroundColor"));
        assertEquals("#FFFFFF", response.path("pages[0].elements[2].style.fontColor"));

        assertEquals("label-body", elementLabelBody.get("elementId"));
        assertEquals("BLOCK", elementLabelBody.get("type"));
        assertEquals("ORANGE", response.path("pages[0].elements[3].style.code"));
        assertEquals("#FF8515", response.path("pages[0].elements[3].style.backGroundColor"));
        assertEquals("#FFFFFF", response.path("pages[0].elements[3].style.fontColor"));

        assertEquals("label-text", elementLabelText.get("elementId"));
        assertEquals("Метка", elementLabelText.get("value"));
        assertEquals("TEXT", elementLabelText.get("type"));

        assertEquals("Кнопка", elementButton.get("value"));
        assertEquals("primary-button", elementButton.get("elementId"));
        assertEquals("BUTTON", elementButton.get("type"));
        assertEquals("2", response.path("pages[0].elements[5].link.linkAddress"));
        assertEquals("DEEPLINK", response.path("pages[0].elements[5].link.linkType"));

        assertEquals("Creative", response.path("name"));
        assertEquals("LIGHT_THEME", response.path("theme"));
        assertEquals("", response.path("offerType"));
        assertEquals(false, response.path("deleted"));
    }
}

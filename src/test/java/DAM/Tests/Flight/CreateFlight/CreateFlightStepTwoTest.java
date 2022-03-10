package DAM.Tests.Flight.CreateFlight;

import DAM.EndPoints;
import DAM.Flights.CreateFlightStepOne;
import DAM.LogIn;
import DAM.Parametrs.Flights.CreateFlightStepTwoParams;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import java.util.LinkedHashMap;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class CreateFlightStepTwoTest {
    String logIn, body, flights, placement, id;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();
        id = new CreateFlightStepOne().getId();

        flights = new EndPoints().getFlights();
        body = new CreateFlightStepTwoParams().getFlight();
        placement = new EndPoints().getPlacement();
    }

    @Test
    public void successCreate() {
        Response response = given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .when()
                .post(flights + id + placement)
                .then()
                .extract().response();

        LinkedHashMap<String,Object> locations = response.path("locations[0]");
        LinkedHashMap<String,Object> positions = response.path("locations[0].positions[0]");
        LinkedHashMap<String,Object> formats = response.path("locations[0].positions[0].formats[0]");

        assertEquals("Мобильный Банк", response.path("name"));
        assertEquals("c6535841-1989-4287-8c5e-51c30830c562", response.path("id"));
        assertEquals("MOBILE", response.path("code"));
        assertEquals("Главный Экран", locations.get("name"));
        assertEquals("038edcaf-2d19-4dfa-9c09-3ed09a9f4e5a", locations.get("id"));
        assertEquals("MAIN_PAGE", locations.get("code"));
        assertEquals("Баннер при входе", positions.get("name"));
        assertEquals("89a2018f-55e8-4ac3-930e-006867a9c3ca", positions.get("id"));
        assertEquals("FULL_SCREEN", positions.get("code"));
        assertEquals("Информационный Pre-roll", formats.get("name"));
        assertEquals("1721cf87-f07c-496a-8c29-2eb8a3cc15b0", formats.get("id"));
        assertEquals("PRE-ROLL_INFO_1", formats.get("code"));
    }
}

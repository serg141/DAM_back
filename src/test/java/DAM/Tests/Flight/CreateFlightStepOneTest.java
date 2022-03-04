package DAM.Tests.Flight;

import DAM.EndPoints;
import DAM.LogIn;
import DAM.Parametrs.Flights.CreateFlightStepOneParams;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class CreateFlightStepOneTest {
    String logIn, body, flights;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();
        flights = new EndPoints().getFlights();
        body = new CreateFlightStepOneParams().getFlight();
    }

    @Test
    public void successCreate() {
        Response response = given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .when()
                .post(flights)
                .then().statusCode(200)
                .extract().response();

        int priority = response.path("priority");
        int stage = response.path("stage");
        int value = response.path("frequency.value");

        assertEquals("FlightTest", response.path("name"));
        assertEquals(40, priority);
        assertEquals("DRAFT", response.path("status"));
        assertEquals("STANDARD", response.path("purpose"));
        assertEquals("DAILY", response.path("frequency.term"));
        assertEquals(1, value);
        assertEquals("NONE", response.path("socialSegmentsOrigin"));
        assertEquals(1, stage);
        assertEquals("Камынин Сергей Игоревич", response.path("createdBy"));
    }
}

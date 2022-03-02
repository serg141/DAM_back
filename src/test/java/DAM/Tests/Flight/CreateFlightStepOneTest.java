package DAM.Tests.Flight;

import DAM.EndPoints;
import DAM.LogIn;
import DAM.Parametrs.CreateFlightStepOneParams;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class CreateFlightStepOneTest {

    @Test
    public void successCreate() throws JSONException {
        String logIn = new LogIn().logIn();
        String body = new CreateFlightStepOneParams().getFlight();
        String flights = new EndPoints().getFlights();

        Response response = given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .when()
                .post(flights)
                .then().log().all().extract().response();

        Integer priority = response.path("priority");
        Integer stage = response.path("stage");
        Integer value = response.path("frequency.value");

        assertEquals("FlightTest", response.path("name"));
        assertEquals(40, priority.intValue());
        assertEquals("DRAFT", response.path("status"));
        assertEquals("STANDARD", response.path("purpose"));
        assertEquals("DAILY", response.path("frequency.term"));
        assertEquals(1, value.intValue());
        assertEquals("NONE", response.path("socialSegmentsOrigin"));
        assertEquals(1, stage.intValue());
        assertEquals("Камынин Сергей Игоревич", response.path("createdBy"));
    }
}

package DAM.Tests.Flight.CreateFlight;

import DAM.Flights.CreateFlightStepOne;
import org.json.JSONException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreateFlightStepOneTest {

    @Test
    public void successCreate() throws JSONException {
        String[] dataFlightStepOne = new CreateFlightStepOne().getFlightStepOne();

        assertEquals("FlightTest", dataFlightStepOne[0]);
        assertEquals("DRAFT", dataFlightStepOne[1]);
        assertEquals("STANDARD", dataFlightStepOne[2]);
        assertEquals("DAILY", dataFlightStepOne[3]);
        assertEquals("Камынин Сергей Игоревич", dataFlightStepOne[4]);
    }
}

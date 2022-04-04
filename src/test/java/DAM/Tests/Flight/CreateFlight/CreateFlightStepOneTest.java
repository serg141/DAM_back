package DAM.Tests.Flight.CreateFlight;

import DAM.Helper.Flights.CreateFlightStepOne;
import org.json.JSONException;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CreateFlightStepOneTest {

    @Test
    public void successCreate() throws JSONException {
        ArrayList<String> dataFlightStepOne = new CreateFlightStepOne().getFlightStepOne();

        assertEquals("FlightTest", dataFlightStepOne.get(0));
        assertEquals("DRAFT", dataFlightStepOne.get(1));
        assertEquals("STANDARD", dataFlightStepOne.get(2));
        assertEquals("DAILY", dataFlightStepOne.get(3));
        assertEquals("Камынин Сергей Игоревич", dataFlightStepOne.get(4));
    }
}

package DAM.Tests.Flight.CreateFlight;

import DAM.Flights.CreateFlightWithAuthParameters;
import org.json.JSONException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreateFlightWithAuthParametersTest {

    @Test
    public void successCreate() throws JSONException {
        String[] dataFlightStepThree = new CreateFlightWithAuthParameters().getFlightStepThree();

        assertTrue(dataFlightStepThree[1].contains("ageAll"));
        assertTrue(dataFlightStepThree[2].contains("genderAll"));
        assertEquals("ee0ef64f-6e90-4f9c-981d-895288796529", dataFlightStepThree[0]);
    }
}

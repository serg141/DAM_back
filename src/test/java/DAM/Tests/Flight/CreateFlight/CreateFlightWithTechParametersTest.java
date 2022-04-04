package DAM.Tests.Flight.CreateFlight;

import DAM.Helper.Flights.CreateFlightWithOutTechParameters;
import DAM.Helper.Flights.CreateFlightWithTechParameters;
import org.json.JSONException;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CreateFlightWithTechParametersTest {

    @Test
    public void successCreateWithOutVersion() throws JSONException {
        ArrayList<String> dataFlightWithOutTechVersion = new CreateFlightWithOutTechParameters().getFlightStepFour();

        assertEquals("64c2f22d-7566-48b3-a9cb-af11f1868494", dataFlightWithOutTechVersion.get(0));
        assertEquals("{}", dataFlightWithOutTechVersion.get(1));
        assertEquals("a27c47b7-500f-48d9-b4ff-517451c9c17e", dataFlightWithOutTechVersion.get(2));
        assertEquals("{}", dataFlightWithOutTechVersion.get(3));
        assertEquals("{}", dataFlightWithOutTechVersion.get(4));
    }

    @Test
    public void successCreateWithVersions() throws JSONException {
        ArrayList<String> dataFlightWithTechVersion = new CreateFlightWithTechParameters().getFlightStepFour();
        assertEquals("64c2f22d-7566-48b3-a9cb-af11f1868494", dataFlightWithTechVersion.get(0));
        assertEquals("15.4.0", dataFlightWithTechVersion.get(1));
        assertEquals("15.4.2", dataFlightWithTechVersion.get(2));
        assertEquals("a27c47b7-500f-48d9-b4ff-517451c9c17e", dataFlightWithTechVersion.get(3));
        assertEquals("15.4.0", dataFlightWithTechVersion.get(4));
        assertEquals("15.4.2", dataFlightWithTechVersion.get(5));
    }
}

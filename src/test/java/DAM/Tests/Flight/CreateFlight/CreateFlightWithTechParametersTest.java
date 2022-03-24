package DAM.Tests.Flight.CreateFlight;

import DAM.Helper.Flights.CreateFlightWithOutTechParameters;
import DAM.Helper.Flights.CreateFlightWithTechParameters;
import org.json.JSONException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreateFlightWithTechParametersTest {

    @Test
    public void successCreateWithOutVersion() throws JSONException {
        String[] dataFlightWithOutTechVersion = new CreateFlightWithOutTechParameters().getFlightStepFour();

        assertEquals("64c2f22d-7566-48b3-a9cb-af11f1868494", dataFlightWithOutTechVersion[0]);
        assertEquals("{}", dataFlightWithOutTechVersion[1]);
        assertEquals("a27c47b7-500f-48d9-b4ff-517451c9c17e", dataFlightWithOutTechVersion[2]);
        assertEquals("{}", dataFlightWithOutTechVersion[3]);
        assertEquals("{}", dataFlightWithOutTechVersion[4]);
    }

    @Test
    public void successCreateWithVersions() throws JSONException {
        String[] dataFlightWithTechVersion = new CreateFlightWithTechParameters().getFlightStepFour();
        assertEquals("64c2f22d-7566-48b3-a9cb-af11f1868494", dataFlightWithTechVersion[0]);
        assertEquals("15.4.0", dataFlightWithTechVersion[1]);
        assertEquals("15.4.2", dataFlightWithTechVersion[2]);
        assertEquals("a27c47b7-500f-48d9-b4ff-517451c9c17e", dataFlightWithTechVersion[3]);
        assertEquals("15.4.0", dataFlightWithTechVersion[4]);
        assertEquals("15.4.2", dataFlightWithTechVersion[5]);
    }
}

package DAM.Tests.Flight.CreateFlight;

import DAM.Helper.Flights.CreateFlightStepFiveGhostNone;
import DAM.Helper.Flights.CreateFlightStepFiveGhostWithOutPolling;
import DAM.Helper.Flights.CreateFlightStepFiveGhostWithPolling;
import org.json.JSONException;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CreateFlightStepFiveGhostTest {

    @Test
    public void successCreateFlightStepFiveGhostNone() throws JSONException {
        ArrayList<String> dataFlightStepFiveGhostNone = new CreateFlightStepFiveGhostNone().getFlightStepFiveGhostNone();

        assertEquals("1", dataFlightStepFiveGhostNone.get(0));
        assertEquals("NONE", dataFlightStepFiveGhostNone.get(1));

        assertEquals("https://core-cms-backend.dso-core.apps.d0-oscp.corp.dev.vtb/projects/dam/files/597733151_33.png",
                dataFlightStepFiveGhostNone.get(2));
        assertEquals("image", dataFlightStepFiveGhostNone.get(3));
        assertEquals("IMAGE", dataFlightStepFiveGhostNone.get(4));
        assertEquals("2", dataFlightStepFiveGhostNone.get(5));
        assertEquals("INTERNAL", dataFlightStepFiveGhostNone.get(6));

        assertEquals("Заголовок", dataFlightStepFiveGhostNone.get(7));
        assertEquals("heading", dataFlightStepFiveGhostNone.get(8));
        assertEquals("TEXT", dataFlightStepFiveGhostNone.get(9));

        assertEquals("Описание", dataFlightStepFiveGhostNone.get(10));
        assertEquals("description", dataFlightStepFiveGhostNone.get(11));
        assertEquals("TEXT", dataFlightStepFiveGhostNone.get(12));

        assertEquals("body", dataFlightStepFiveGhostNone.get(13));
        assertEquals("BLOCK", dataFlightStepFiveGhostNone.get(14));
        assertEquals("2", dataFlightStepFiveGhostNone.get(15));
        assertEquals("INTERNAL", dataFlightStepFiveGhostNone.get(16));
        assertEquals("TIFFANY", dataFlightStepFiveGhostNone.get(17));
        assertEquals("#00BCD4", dataFlightStepFiveGhostNone.get(18));
        assertEquals("#FFFFFF", dataFlightStepFiveGhostNone.get(19));

        assertEquals("Creative", dataFlightStepFiveGhostNone.get(20));
        assertEquals("LIGHT_THEME", dataFlightStepFiveGhostNone.get(21));
        assertEquals("", dataFlightStepFiveGhostNone.get(22));
    }

    @Test
    public void successCreateFlightStepFiveGhostWithPolling() throws JSONException {
        assertEquals("CROSS_WITH_POLLING", new CreateFlightStepFiveGhostWithPolling()
                .getFlightStepFiveGhostWithPolling());
    }

    @Test
    public void successCreateFlightStepFiveGhostWithOutPolling() throws JSONException {
        assertEquals("CROSS_WITHOUT_POLLING", new CreateFlightStepFiveGhostWithOutPolling()
                .getFlightStepFiveGhostWithOutPolling());
    }
}

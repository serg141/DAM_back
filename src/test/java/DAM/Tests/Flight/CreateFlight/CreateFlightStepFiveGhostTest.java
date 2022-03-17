package DAM.Tests.Flight.CreateFlight;

import DAM.Flights.CreateFlightStepFiveGhostNone;
import DAM.Flights.CreateFlightStepFiveGhostWithOutPolling;
import DAM.Flights.CreateFlightStepFiveGhostWithPolling;
import org.json.JSONException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreateFlightStepFiveGhostTest {

    @Test
    public void successCreateFlightStepFiveGhostNone() throws JSONException {
        String[] dataFlightStepFiveGhostNone = new CreateFlightStepFiveGhostNone().getFlightStepFiveGhostNone();

        assertEquals("1", dataFlightStepFiveGhostNone[0]);
        assertEquals("NONE", dataFlightStepFiveGhostNone[1]);

        assertEquals("https://core-cms-backend.dso-core.apps.d0-oscp.corp.dev.vtb/projects/dam/files/597733151_33.png",
                dataFlightStepFiveGhostNone[2]);
        assertEquals("image", dataFlightStepFiveGhostNone[3]);
        assertEquals("IMAGE", dataFlightStepFiveGhostNone[4]);
        assertEquals("2", dataFlightStepFiveGhostNone[5]);
        assertEquals("INTERNAL", dataFlightStepFiveGhostNone[6]);

        assertEquals("Заголовок", dataFlightStepFiveGhostNone[7]);
        assertEquals("heading", dataFlightStepFiveGhostNone[8]);
        assertEquals("TEXT", dataFlightStepFiveGhostNone[9]);

        assertEquals("Описание", dataFlightStepFiveGhostNone[10]);
        assertEquals("description", dataFlightStepFiveGhostNone[11]);
        assertEquals("TEXT", dataFlightStepFiveGhostNone[12]);

        assertEquals("body", dataFlightStepFiveGhostNone[13]);
        assertEquals("BLOCK", dataFlightStepFiveGhostNone[14]);
        assertEquals("2", dataFlightStepFiveGhostNone[15]);
        assertEquals("INTERNAL", dataFlightStepFiveGhostNone[16]);
        assertEquals("TIFFANY", dataFlightStepFiveGhostNone[17]);
        assertEquals("#00BCD4", dataFlightStepFiveGhostNone[18]);
        assertEquals("#FFFFFF", dataFlightStepFiveGhostNone[19]);

        assertEquals("Creative", dataFlightStepFiveGhostNone[20]);
        assertEquals("LIGHT_THEME", dataFlightStepFiveGhostNone[21]);
        assertEquals("", dataFlightStepFiveGhostNone[22]);
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

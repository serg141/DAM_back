package DAM.Tests.Flight.CreateFlight;

import DAM.Helper.Flights.CreateFlightStepFivePrerollNone;
import DAM.Helper.Flights.CreateFlightStepFivePrerollWithOutPolling;
import DAM.Helper.Flights.CreateFlightStepFivePrerollWithPolling;
import org.json.JSONException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreateFlightStepFivePrerollTest {

    @Test
    public void successCreateFlightStepFivePrerollNone() throws JSONException {
        String[] dataFlightStepFivePrerollNone = new CreateFlightStepFivePrerollNone().getFlightStepFivePrerollNone();
        assertEquals("1", dataFlightStepFivePrerollNone[0]);
        assertEquals("NONE", dataFlightStepFivePrerollNone[1]);

        assertEquals("https://core-cms-backend.dso-core.apps.d0-oscp.corp.dev.vtb/projects/dam/files/597733151_33.png",
                dataFlightStepFivePrerollNone[2]);
        assertEquals("preroll-image", dataFlightStepFivePrerollNone[3]);
        assertEquals("IMAGE", dataFlightStepFivePrerollNone[4]);
        assertEquals("Https:www.vtb.ru", dataFlightStepFivePrerollNone[5]);
        assertEquals("EXTERNAL", dataFlightStepFivePrerollNone[6]);

        assertEquals("Заголовок", dataFlightStepFivePrerollNone[7]);
        assertEquals("preroll-heading", dataFlightStepFivePrerollNone[8]);
        assertEquals("TEXT", dataFlightStepFivePrerollNone[9]);

        assertEquals("Описание", dataFlightStepFivePrerollNone[10]);
        assertEquals("preroll-description", dataFlightStepFivePrerollNone[11]);
        assertEquals("TEXT", dataFlightStepFivePrerollNone[12]);

        assertEquals("Кнопка", dataFlightStepFivePrerollNone[13]);
        assertEquals("preroll-button", dataFlightStepFivePrerollNone[14]);
        assertEquals("BUTTON", dataFlightStepFivePrerollNone[15]);
        assertEquals("Https:www.vtb.ru", dataFlightStepFivePrerollNone[16]);
        assertEquals("EXTERNAL", dataFlightStepFivePrerollNone[17]);

        assertEquals("Creative", dataFlightStepFivePrerollNone[18]);
        assertEquals("LIGHT_THEME", dataFlightStepFivePrerollNone[19]);
        assertEquals("", dataFlightStepFivePrerollNone[20]);
    }

    @Test
    public void successCreateFlightStepFivePrerollWithOutPolling() throws JSONException {
        assertEquals("CROSS_WITHOUT_POLLING", new CreateFlightStepFivePrerollWithOutPolling().
                getFlightStepFivePrerollWithOutPolling());
    }

    @Test
    public void successCreateFlightStepFivePrerollWithPolling() throws JSONException {
        assertEquals("CROSS_WITH_POLLING", new CreateFlightStepFivePrerollWithPolling().
                getFlightStepFivePrerollWithPolling());
    }
}

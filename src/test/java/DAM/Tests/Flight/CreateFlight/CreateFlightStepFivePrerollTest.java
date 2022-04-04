package DAM.Tests.Flight.CreateFlight;

import DAM.Helper.Flights.CreateFlightStepFivePrerollNone;
import DAM.Helper.Flights.CreateFlightStepFivePrerollWithOutPolling;
import DAM.Helper.Flights.CreateFlightStepFivePrerollWithPolling;
import org.json.JSONException;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CreateFlightStepFivePrerollTest {

    @Test
    public void successCreateFlightStepFivePrerollNone() throws JSONException {
        ArrayList<String> dataFlightStepFivePrerollNone = new CreateFlightStepFivePrerollNone()
                .getFlightStepFivePrerollNone();
        assertEquals("1", dataFlightStepFivePrerollNone.get(0));
        assertEquals("NONE", dataFlightStepFivePrerollNone.get(1));

        assertEquals("https://core-cms-backend.dso-core.apps.d0-oscp.corp.dev.vtb/projects/dam/files/597733151_33.png",
                dataFlightStepFivePrerollNone.get(2));
        assertEquals("preroll-image", dataFlightStepFivePrerollNone.get(3));
        assertEquals("IMAGE", dataFlightStepFivePrerollNone.get(4));
        assertEquals("Https:www.vtb.ru", dataFlightStepFivePrerollNone.get(5));
        assertEquals("EXTERNAL", dataFlightStepFivePrerollNone.get(6));

        assertEquals("Заголовок", dataFlightStepFivePrerollNone.get(7));
        assertEquals("preroll-heading", dataFlightStepFivePrerollNone.get(8));
        assertEquals("TEXT", dataFlightStepFivePrerollNone.get(9));

        assertEquals("Описание", dataFlightStepFivePrerollNone.get(10));
        assertEquals("preroll-description", dataFlightStepFivePrerollNone.get(11));
        assertEquals("TEXT", dataFlightStepFivePrerollNone.get(12));

        assertEquals("Кнопка", dataFlightStepFivePrerollNone.get(13));
        assertEquals("preroll-button", dataFlightStepFivePrerollNone.get(14));
        assertEquals("BUTTON", dataFlightStepFivePrerollNone.get(15));
        assertEquals("Https:www.vtb.ru", dataFlightStepFivePrerollNone.get(16));
        assertEquals("EXTERNAL", dataFlightStepFivePrerollNone.get(17));

        assertEquals("Creative", dataFlightStepFivePrerollNone.get(18));
        assertEquals("LIGHT_THEME", dataFlightStepFivePrerollNone.get(19));
        assertEquals("", dataFlightStepFivePrerollNone.get(20));
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

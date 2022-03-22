package DAM.Tests.Flight.CreateFlight;

import DAM.Helper.Flights.CreateFlightStepFiveSliderNone;
import DAM.Helper.Flights.CreateFlightStepFiveSliderWithOutPolling;
import DAM.Helper.Flights.CreateFlightStepFiveSliderWithPolling;
import org.json.JSONException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreateFlightStepFiveSliderTest {

    @Test
    public void successCreateFlightStepFiveSliderNone() throws JSONException {
        String[] dataFlightStepFiveSliderNone = new CreateFlightStepFiveSliderNone().getFlightStepFiveSliderNone();

        assertEquals("1", dataFlightStepFiveSliderNone[0]);
        assertEquals("NONE", dataFlightStepFiveSliderNone[1]);

        assertEquals("Заголовок", dataFlightStepFiveSliderNone[2]);
        assertEquals("heading", dataFlightStepFiveSliderNone[3]);
        assertEquals("TEXT", dataFlightStepFiveSliderNone[4]);

        assertEquals("Описание", dataFlightStepFiveSliderNone[5]);
        assertEquals("description", dataFlightStepFiveSliderNone[6]);
        assertEquals("TEXT", dataFlightStepFiveSliderNone[7]);

        assertEquals("body", dataFlightStepFiveSliderNone[8]);
        assertEquals("BLOCK", dataFlightStepFiveSliderNone[9]);
        assertEquals("FUCHSIA", dataFlightStepFiveSliderNone[10]);
        assertEquals("#F86D86", dataFlightStepFiveSliderNone[11]);
        assertEquals("#FFFFFF", dataFlightStepFiveSliderNone[12]);

        assertEquals("label-body", dataFlightStepFiveSliderNone[13]);
        assertEquals("BLOCK", dataFlightStepFiveSliderNone[14]);
        assertEquals("ORANGE", dataFlightStepFiveSliderNone[15]);
        assertEquals("#FF8515", dataFlightStepFiveSliderNone[16]);
        assertEquals("#FFFFFF", dataFlightStepFiveSliderNone[17]);

        assertEquals("label-text", dataFlightStepFiveSliderNone[18]);
        assertEquals("Метка", dataFlightStepFiveSliderNone[19]);
        assertEquals("TEXT", dataFlightStepFiveSliderNone[20]);

        assertEquals("Кнопка", dataFlightStepFiveSliderNone[21]);
        assertEquals("primary-button", dataFlightStepFiveSliderNone[22]);
        assertEquals("BUTTON", dataFlightStepFiveSliderNone[23]);
        assertEquals("2", dataFlightStepFiveSliderNone[24]);
        assertEquals("DEEPLINK", dataFlightStepFiveSliderNone[25]);

        assertEquals("Creative", dataFlightStepFiveSliderNone[26]);
        assertEquals("LIGHT_THEME", dataFlightStepFiveSliderNone[27]);
        assertEquals("", dataFlightStepFiveSliderNone[28]);
    }

    @Test
    public void successCreateFlightStepFiveSliderWithOutPolling() throws JSONException {
        assertEquals("CROSS_WITHOUT_POLLING", new CreateFlightStepFiveSliderWithOutPolling().
                getFlightStepFiveSliderWithOutPolling());
    }

    @Test
    public void successCreateFlightStepFiveSliderWithPolling() throws JSONException {
        assertEquals("CROSS_WITH_POLLING", new CreateFlightStepFiveSliderWithPolling().
                getFlightStepFiveSliderWithPolling());
    }
}

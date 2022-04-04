package DAM.Tests.Flight.CreateFlight;

import DAM.Helper.Flights.CreateFlightStepFiveSliderNone;
import DAM.Helper.Flights.CreateFlightStepFiveSliderWithOutPolling;
import DAM.Helper.Flights.CreateFlightStepFiveSliderWithPolling;
import org.json.JSONException;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CreateFlightStepFiveSliderTest {

    @Test
    public void successCreateFlightStepFiveSliderNone() throws JSONException {
        ArrayList<String> dataFlightStepFiveSliderNone = new CreateFlightStepFiveSliderNone().
                getFlightStepFiveSliderNone();

        assertEquals("1", dataFlightStepFiveSliderNone.get(0));
        assertEquals("NONE", dataFlightStepFiveSliderNone.get(1));

        assertEquals("Заголовок", dataFlightStepFiveSliderNone.get(2));
        assertEquals("heading", dataFlightStepFiveSliderNone.get(3));
        assertEquals("TEXT", dataFlightStepFiveSliderNone.get(4));

        assertEquals("Описание", dataFlightStepFiveSliderNone.get(5));
        assertEquals("description", dataFlightStepFiveSliderNone.get(6));
        assertEquals("TEXT", dataFlightStepFiveSliderNone.get(7));

        assertEquals("body", dataFlightStepFiveSliderNone.get(8));
        assertEquals("BLOCK", dataFlightStepFiveSliderNone.get(9));
        assertEquals("FUCHSIA", dataFlightStepFiveSliderNone.get(10));
        assertEquals("#F86D86", dataFlightStepFiveSliderNone.get(11));
        assertEquals("#FFFFFF", dataFlightStepFiveSliderNone.get(12));

        assertEquals("label-body", dataFlightStepFiveSliderNone.get(13));
        assertEquals("BLOCK", dataFlightStepFiveSliderNone.get(14));
        assertEquals("ORANGE", dataFlightStepFiveSliderNone.get(15));
        assertEquals("#FF8515", dataFlightStepFiveSliderNone.get(16));
        assertEquals("#FFFFFF", dataFlightStepFiveSliderNone.get(17));

        assertEquals("label-text", dataFlightStepFiveSliderNone.get(18));
        assertEquals("Метка", dataFlightStepFiveSliderNone.get(19));
        assertEquals("TEXT", dataFlightStepFiveSliderNone.get(20));

        assertEquals("Кнопка", dataFlightStepFiveSliderNone.get(21));
        assertEquals("primary-button", dataFlightStepFiveSliderNone.get(22));
        assertEquals("BUTTON", dataFlightStepFiveSliderNone.get(23));
        assertEquals("2", dataFlightStepFiveSliderNone.get(24));
        assertEquals("DEEPLINK", dataFlightStepFiveSliderNone.get(25));

        assertEquals("Creative", dataFlightStepFiveSliderNone.get(26));
        assertEquals("LIGHT_THEME", dataFlightStepFiveSliderNone.get(27));
        assertEquals("", dataFlightStepFiveSliderNone.get(28));
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

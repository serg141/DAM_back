package DAM.Tests.Flight.CreateFlight;

import DAM.Helper.Flights.CreateFlightStepTwo;
import org.json.JSONException;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class CreateFlightStepTwoTest {

    @Test
    public void successCreate() throws JSONException {
        ArrayList<String> dataFlightStepTwo = new CreateFlightStepTwo().getFlightStepTwo();

        assertEquals("Мобильный Банк", dataFlightStepTwo.get(0));
        assertEquals("MOBILE", dataFlightStepTwo.get(1));
        assertEquals("Главный Экран", dataFlightStepTwo.get(2));
        assertEquals("MAIN_PAGE", dataFlightStepTwo.get(3));
        assertEquals("Баннер при входе", dataFlightStepTwo.get(4));
        assertEquals("FULL_SCREEN", dataFlightStepTwo.get(5));
        assertEquals("Информационный Pre-roll", dataFlightStepTwo.get(6));
        assertEquals("PRE-ROLL_INFO_1", dataFlightStepTwo.get(7));
    }
}

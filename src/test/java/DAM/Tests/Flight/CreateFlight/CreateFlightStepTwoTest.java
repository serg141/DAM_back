package DAM.Tests.Flight.CreateFlight;

import DAM.Helper.Flights.CreateFlightStepTwo;
import org.json.JSONException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreateFlightStepTwoTest {

    @Test
    public void successCreate() throws JSONException {
        String[] dataFlightStepTwo = new CreateFlightStepTwo().getFlightStepTwo();

        assertEquals("Мобильный Банк", dataFlightStepTwo[0]);
        assertEquals("MOBILE", dataFlightStepTwo[1]);
        assertEquals("Главный Экран", dataFlightStepTwo[2]);
        assertEquals("MAIN_PAGE", dataFlightStepTwo[3]);
        assertEquals("Баннер при входе", dataFlightStepTwo[4]);
        assertEquals("FULL_SCREEN", dataFlightStepTwo[5]);
        assertEquals("Информационный Pre-roll", dataFlightStepTwo[6]);
        assertEquals("PRE-ROLL_INFO_1", dataFlightStepTwo[7]);
    }
}

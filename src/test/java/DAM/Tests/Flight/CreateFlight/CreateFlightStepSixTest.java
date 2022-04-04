package DAM.Tests.Flight.CreateFlight;

import DAM.Helper.Flights.CreateFlightStepSix;
import org.json.JSONException;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CreateFlightStepSixTest {
    @Test
    public void stepSixTest() throws JSONException {
        ArrayList<String> dataFlightStepSix = new CreateFlightStepSix().getFlightStepSix();

        assertEquals("FlightTest", dataFlightStepSix.get(0));
        assertEquals("DAILY", dataFlightStepSix.get(1));
        assertEquals("Мобильный Банк", dataFlightStepSix.get(2));
        assertEquals("Главный Экран", dataFlightStepSix.get(3));
        assertEquals("Баннер при входе", dataFlightStepSix.get(4));
        assertEquals("Информационный Pre-roll", dataFlightStepSix.get(5));
        assertEquals("Траты клиента (Нет счета \"Копилка\")", dataFlightStepSix.get(6));
        assertEquals("Траты клиента", dataFlightStepSix.get(7));
        assertEquals("Нет счета \"Копилка\"", dataFlightStepSix.get(8));
        assertEquals("IOS", dataFlightStepSix.get(9));
        assertEquals("15.4.0", dataFlightStepSix.get(10));
        assertEquals("15.4.2", dataFlightStepSix.get(11));
        assertEquals("15.4.1", dataFlightStepSix.get(12));
    }
}

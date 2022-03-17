package DAM.Tests.Flight.CreateFlight;

import DAM.Flights.CreateFlightStepSix;
import org.json.JSONException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreateFlightStepSixTest {
    @Test
    public void stepSixTest() throws JSONException {
        String[] dataFlightStepSix = new CreateFlightStepSix().getFlightStepSix();

        assertEquals("FlightTest", dataFlightStepSix[0]);
        assertEquals("DAILY", dataFlightStepSix[1]);
        assertEquals("Мобильный Банк", dataFlightStepSix[2]);
        assertEquals("Главный Экран", dataFlightStepSix[3]);
        assertEquals("Баннер при входе", dataFlightStepSix[4]);
        assertEquals("Информационный Pre-roll", dataFlightStepSix[5]);
        assertEquals("Траты клиента (Нет счета \"Копилка\")", dataFlightStepSix[6]);
        assertEquals("Траты клиента", dataFlightStepSix[7]);
        assertEquals("Нет счета \"Копилка\"", dataFlightStepSix[8]);
        assertEquals("IOS", dataFlightStepSix[9]);
        assertEquals("15.4.0", dataFlightStepSix[10]);
        assertEquals("15.4.2", dataFlightStepSix[11]);
        assertEquals("15.4.1", dataFlightStepSix[12]);
    }
}

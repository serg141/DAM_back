package DAM.Tests.Flight;

import DAM.Helper.Flights.FlightPlacement;
import org.json.JSONException;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PlacementTest {

    @Test
    public void placementTest() throws JSONException {
        ArrayList<String> placement = new FlightPlacement().getFlightPlacement();

        assertEquals("Мобильный Банк", placement.get(0));
        assertEquals("MOBILE", placement.get(1));
        assertEquals("Главный Экран", placement.get(2));
        assertEquals("MAIN_PAGE", placement.get(3));
        assertEquals("Баннер при входе", placement.get(4));
        assertEquals("FULL_SCREEN", placement.get(5));
        assertEquals("Информационный Pre-roll", placement.get(6));
        assertEquals("PRE-ROLL_INFO_1", placement.get(7));
    }
}

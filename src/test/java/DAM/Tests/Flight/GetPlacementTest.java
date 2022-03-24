package DAM.Tests.Flight;

import DAM.Helper.Flights.GetPlacement;
import org.json.JSONException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetPlacementTest {

    @Test
    public void getPlacementTest() throws JSONException {
        String[] placements = new GetPlacement().getPlacement();

        assertEquals("Мобильный Банк", placements[0]);
        assertEquals("MOBILE", placements[1]);
        assertEquals("Главный Экран", placements[2]);
        assertEquals("MAIN_PAGE", placements[3]);
        assertEquals("Баннер при входе", placements[4]);
        assertEquals("FULL_SCREEN", placements[5]);
        assertEquals("Информационный Pre-roll", placements[6]);
        assertEquals("PRE-ROLL_INFO_1", placements[7]);
    }
}

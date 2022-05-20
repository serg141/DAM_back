package DAM.Tests.Flight.CopyFlight;

import DAM.Helper.Flights.CopyFlightCSV;
import org.json.JSONException;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class CopyFlightWithCsvTest {

    @Test
    public void flightCSV() throws JSONException {
        String status = new CopyFlightCSV().getStatus();

        assertEquals("Флайт скопирован БЕЗ csv-файла", status);
    }
}

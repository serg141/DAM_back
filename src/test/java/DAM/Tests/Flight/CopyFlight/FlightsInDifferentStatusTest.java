package DAM.Tests.Flight.CopyFlight;

import DAM.Helper.Flights.CopyFlights;
import DAM.Parametrs.Filters.FilterByFlightStatus;
import org.json.JSONException;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class FlightsInDifferentStatusTest {
    @Test
    public void statusActive() throws JSONException {
        String body = new FilterByFlightStatus().getBody1().toString();
        String status = new CopyFlights(body).getStatus();

        assertEquals("Флайт успешно скопирован", status);
    }

    @Test
    public void statusDeclined() throws JSONException {
        String body = new FilterByFlightStatus().getBody2().toString();
        String status = new CopyFlights(body).getStatus();

        assertEquals("Флайт успешно скопирован", status);
    }

    @Test
    public void statusPaused() throws JSONException {
        String body = new FilterByFlightStatus().getBody3().toString();
        String status = new CopyFlights(body).getStatus();

        assertEquals("Флайт успешно скопирован", status);
    }

    @Test
    public void statusPending() throws JSONException {
        String body = new FilterByFlightStatus().getBody4().toString();
        String status = new CopyFlights(body).getStatus();

        assertEquals("Флайт успешно скопирован", status);
    }

    @Test
    public void statusModerationClaimed() throws JSONException {
        String body = new FilterByFlightStatus().getBody5().toString();
        String status = new CopyFlights(body).getStatus();

        assertEquals("Флайт успешно скопирован", status);
    }

    @Test
    public void statusDraft() throws JSONException {
        String body = new FilterByFlightStatus().getBody6().toString();
        String status = new CopyFlights(body).getStatus();

        assertEquals("Флайт успешно скопирован", status);
    }

    @Test
    public void statusFinished() throws JSONException {
        String body = new FilterByFlightStatus().getBody7().toString();
        String status = new CopyFlights(body).getStatus();

        assertEquals("Флайт успешно скопирован", status);
    }

    @Test
    public void statusRemoved() throws JSONException {
        String body = new FilterByFlightStatus().getBody8().toString();
        String status = new CopyFlights(body).getStatus();

        assertEquals("Флайт успешно скопирован", status);
    }
}

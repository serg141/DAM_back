package DAM.Tests.Filters;

import DAM.Helper.Filters.Filters;
import org.json.JSONException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class FiltersTest {

    @Test (priority = 1)
    public void byId() throws JSONException {
        String testId = new Filters().FilterId().get(0);

        assertEquals("075039d1-ba51-40ea-81b3-f5b1a09ab385", testId);
    }

    @Test (priority = 2)
    public void byName() throws JSONException {
        String testName = new Filters().FilterName().get(0);

        assertEquals("CampaignForFlight", testName);
    }

    @Test (priority = 2)
    public void byStatus() throws JSONException {
        boolean status = new Filters().FilterStatus();

        assertTrue(status);
    }

    @Test (priority = 2)
    public void byCamp() throws JSONException {
        int camp = new Filters().CampStatus();

        assertEquals(4, camp);
    }

    @Test (priority = 2)
    public void byFlight() throws JSONException {
        int flight = new Filters().FlightStatus();

        assertEquals(8, flight);
    }

    @Test (priority = 2)
    public void byPlacement() throws JSONException {
        boolean placement = new Filters().FilterPlacements();

        assertTrue(placement);
    }

    @Test (priority = 3)
    public void byCreatorId() throws JSONException {
        boolean creator = new Filters().FilterCreatorId();

        assertTrue(creator);
    }
}

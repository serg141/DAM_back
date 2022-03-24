package DAM.Tests.Flight;

import DAM.Helper.Flights.GetSegmentsTech;
import org.json.JSONException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetSegmentsTechTest {

    @Test
    public void successCreate() throws JSONException {
        String[] tech = new GetSegmentsTech().getSegmentsTech();

        assertEquals("64c2f22d-7566-48b3-a9cb-af11f1868494", tech[0]);
        assertEquals("15.4.0", tech[1]);
        assertEquals("15.4.2", tech[2]);
        assertEquals("ee0ef64f-6e90-4f9c-981d-895288796529", tech[3]);
    }
}

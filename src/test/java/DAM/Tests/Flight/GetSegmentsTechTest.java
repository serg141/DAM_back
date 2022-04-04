package DAM.Tests.Flight;

import DAM.Helper.Flights.SegmentsTech;
import org.json.JSONException;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GetSegmentsTechTest {

    @Test
    public void successCreate() throws JSONException {
        ArrayList<String> tech = new SegmentsTech().getSegmentsTech();

        assertEquals("64c2f22d-7566-48b3-a9cb-af11f1868494", tech.get(0));
        assertEquals("15.4.0", tech.get(1));
        assertEquals("15.4.2", tech.get(2));
        assertEquals("ee0ef64f-6e90-4f9c-981d-895288796529", tech.get(3));
    }
}

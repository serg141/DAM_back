package DAM.Tests.Flight;

import DAM.Helper.Flights.SegmentsSocial;
import org.json.JSONException;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GetSegmentsSocialTest {

    @Test
    public void getSegmentsTest() throws JSONException {
        ArrayList<String> segments = new SegmentsSocial().getSegments();

        assertEquals("ee0ef64f-6e90-4f9c-981d-895288796529", segments.get(0));
        assertEquals("ageAll", segments.get(1));
        assertEquals("genderAll", segments.get(2));
    }
}

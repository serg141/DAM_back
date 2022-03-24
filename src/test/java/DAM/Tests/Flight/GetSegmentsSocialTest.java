package DAM.Tests.Flight;

import DAM.Helper.Flights.GetSegmentsSocial;
import org.json.JSONException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetSegmentsSocialTest {

    @Test
    public void getSegmentsTest() throws JSONException {
        String[] segments = new GetSegmentsSocial().getSegments();

        assertEquals("ee0ef64f-6e90-4f9c-981d-895288796529", segments[0]);
        assertEquals("ageAll", segments[1]);
        assertEquals("genderAll", segments[2]);
    }
}

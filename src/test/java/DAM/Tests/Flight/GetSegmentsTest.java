package DAM.Tests.Flight;

import DAM.Helper.Flights.GetSegments;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GetSegmentsTest {

    @Test(priority = 1)
    public void GetSegmentsSocialTest() throws JSONException {
        ArrayList<String> segments = new GetSegments().GetSegmentsSocial();

        assertEquals("ee0ef64f-6e90-4f9c-981d-895288796529", segments.get(0));
        assertEquals("ageAll", segments.get(1));
        assertEquals("genderAll", segments.get(2));
    }

    @Test(priority = 2)
    public void GetSegmentsTechTest() throws JSONException {
        ArrayList<String> tech = new GetSegments().GetSegmentsTech();

        assertEquals("64c2f22d-7566-48b3-a9cb-af11f1868494", tech.get(0));
        assertEquals("15.4.0", tech.get(1));
        assertEquals("15.4.2", tech.get(2));
        assertEquals("ee0ef64f-6e90-4f9c-981d-895288796529", tech.get(3));
    }

    @Test(priority = 3)
    public void GetSegmentsCategoriesSocialTest() {
        ArrayList<String> categories = new GetSegments().GetSegmentCategories();

        assertEquals("SPEND", categories.get(0));
        assertEquals("CLIENTTYPE", categories.get(1));
        assertEquals("BLACKLIST", categories.get(2));
        assertEquals("AGE", categories.get(3));
        assertEquals("GENDER", categories.get(4));
    }
}

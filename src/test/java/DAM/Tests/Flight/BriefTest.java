package DAM.Tests.Flight;

import DAM.Helper.Flights.Brief;
import org.json.JSONException;
import org.testng.annotations.Test;


import static org.junit.Assert.assertEquals;

public class BriefTest {

    @Test(priority = 1)
    public void addBriefTest() {
        String fileName = new Brief().DownloadBrief().get(0);

        assertEquals("Test_Brief.docx", fileName);
    }

    @Test(priority = 2)
    public void getBriefTest() throws JSONException {
        String id = new Brief().GetBrief();

        assertEquals("Test_Brief.docx", id);
    }
}

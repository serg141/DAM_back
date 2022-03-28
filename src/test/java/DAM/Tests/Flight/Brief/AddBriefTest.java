package DAM.Tests.Flight.Brief;

import DAM.Helper.Flights.DownloadBrief;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddBriefTest {

    @Test
    public void successAddBriefTest() {
        String fileName = new DownloadBrief().getBriefName()[0];

        assertEquals("Test_Brief.docx", fileName);
    }
}

package DAM.Tests.Campaign;

import DAM.Campaigns.GetTechReport;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetTechReportTest {
    String[] techReport;

    @Before
    public void getEndpoint() throws JSONException {
        techReport = new GetTechReport().getReport();
    }

    @Test
    public void getTechReport() {
        Integer i = 0;
        assertEquals("circle", techReport[0]);
        assertEquals("Каналы", techReport[1]);
    }
}

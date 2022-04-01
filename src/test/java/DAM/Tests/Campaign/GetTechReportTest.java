package DAM.Tests.Campaign;

import DAM.Helper.Campaigns.GetTechReport;
import org.json.JSONException;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GetTechReportTest {

    @Test
    public void getTechReport() throws JSONException {
        ArrayList<String> editCamp = new GetTechReport().getReport1();
        assertEquals("circle", editCamp.get(0));
        assertEquals("Каналы", editCamp.get(1));
    }
}

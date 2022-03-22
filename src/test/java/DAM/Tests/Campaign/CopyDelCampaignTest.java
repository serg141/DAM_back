package DAM.Tests.Campaign;

import DAM.Helper.Campaigns.CopyDelCampaign;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CopyDelCampaignTest {
    String[] data;

    @Before
    public void getEndpoint() throws JSONException {
       data = new CopyDelCampaign().getCampData();
    }

    @Test
    public void duplicateCampaigns() {
        assertTrue(data[0].contains("copy_"));
        assertEquals("DRAFT", data[1]);
        assertEquals("REMOVED", data[2]);
    }
}

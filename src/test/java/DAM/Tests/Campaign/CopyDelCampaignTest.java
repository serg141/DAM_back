package DAM.Tests.Campaign;

import DAM.Helper.Campaigns.CopyDelCampaign;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CopyDelCampaignTest {

    @Test
    public void duplicateCampaigns() {
        ArrayList<String> copyCamp = new CopyDelCampaign().getDataCamp();
        assertTrue(copyCamp.get(0).contains("copy_"));
        assertEquals("DRAFT", copyCamp.get(1));
        assertEquals("REMOVED", copyCamp.get(2));
    }
}

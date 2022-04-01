package DAM.Tests.Campaign;

import DAM.Helper.Campaigns.GetCampaignById;
import org.json.JSONException;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetCampaignByIdTest {

    @Test
    public void getCampaignsById() throws JSONException {
        ArrayList<String> getCamp = new GetCampaignById().getGetCamp();
        assertTrue(getCamp.get(0).contains("CampaignSPK"));
        assertEquals("SPK", getCamp.get(1));
    }
}

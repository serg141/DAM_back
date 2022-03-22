package DAM.Tests.Campaign;

import DAM.Helper.Campaigns.GetCampaignById;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetCampaignByIdTest {
    String[] campaign;

    @Before
    public void getEndpoint() throws JSONException {
        campaign = new GetCampaignById().getCampaign();
    }

    @Test
    public void getCampaignsById() {
        assertTrue(campaign[0].contains("CampaignSPK"));
        assertEquals("SPK", campaign[1]);
    }
}

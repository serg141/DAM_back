package DAM.Tests.Campaign;

import DAM.Helper.Campaigns.CreateCampaignNoSPK;
import DAM.Helper.Campaigns.CreateCampaignSPK;
import org.json.JSONException;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CreateCampaignTest {

    @Test
    public void successCreateSPK() throws JSONException {
        ArrayList<String> campaign = new CreateCampaignSPK().getCamp();
        assertEquals("CampaignSPK", campaign.get(0));
        assertEquals("SPK", campaign.get(1));
    }

    @Test
    public void successCreateNoSPK() throws JSONException {
        ArrayList<String> campaign = new CreateCampaignNoSPK().getCamp();
        assertEquals("CampaignTest", campaign.get(0));
        assertEquals("STANDARD", campaign.get(1));
    }
}

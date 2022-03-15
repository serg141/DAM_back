package DAM.Tests.Campaign;

import DAM.Campaigns.EditCampaignNoSPK;
import DAM.Campaigns.EditCampaignSPK;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EditCampaignTest {
    String[] editCampaignNoSPK, editCampaignSPK;

    @Before
    public void getEndpoint() throws JSONException {
        editCampaignNoSPK = new EditCampaignNoSPK().getCampaign();
        editCampaignSPK = new EditCampaignSPK().getCampaign();
    }

    @Test
    public void putCampaignsToSPK() {
        assertEquals("CampaignSPKEdit", editCampaignNoSPK[0]);
        assertEquals("SPK", editCampaignNoSPK[1]);
    }

    @Test
    public void putCampaignsToNoSPK() {
        assertEquals("CampaignEdit", editCampaignSPK[0]);
        assertEquals("STANDARD", editCampaignSPK[1]);
    }
}

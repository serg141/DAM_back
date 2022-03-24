package DAM.Tests.Campaign;

import DAM.Helper.Campaigns.CreateCampaignNoSPK;
import DAM.Helper.Campaigns.CreateCampaignSPK;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreateCampaignTest {
    String[] newCampaignNoSPK, newCampaignSPK;

    @Before
    public void getEndpoint() throws JSONException {
        newCampaignNoSPK = new CreateCampaignNoSPK().getCampaignNoSPK();
        newCampaignSPK = new CreateCampaignSPK().getCampaignSPK();
    }

    @Test
    public void successCreateNoSPK() {
        assertEquals("CampaignTest", newCampaignNoSPK[0]);
        assertEquals("STANDARD", newCampaignNoSPK[1]);
    }

    @Test
    public void successCreateSPK() {
        assertEquals("CampaignSPK", newCampaignSPK[0]);
        assertEquals("SPK", newCampaignSPK[1]);
    }
}

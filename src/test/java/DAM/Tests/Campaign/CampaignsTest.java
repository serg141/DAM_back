package DAM.Tests.Campaign;

import DAM.Helper.Campaigns.CampaignSPK;
import DAM.Helper.Campaigns.CampaignStandard;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CampaignsTest {

    @Test (priority = 1)
    public void successCreateSPK() throws JSONException {
        ArrayList<String> campaign = new CampaignSPK().CreateCampaigns();
        assertEquals("CampaignSPK", campaign.get(0));
        assertEquals("SPK", campaign.get(1));
    }

    @Test (priority = 2)
    public void getCampaignsById() throws JSONException {
        ArrayList<String> getCamp = new CampaignSPK().GetCampaigns();
        assertTrue(getCamp.get(0).contains("CampaignSPK"));
        assertEquals("SPK", getCamp.get(1));
    }

    @Test (priority = 3)
    public void editCampaigns() throws JSONException {
        ArrayList<String> editCamp = new CampaignSPK().EditCampaigns();
        assertEquals("CampaignEdit", editCamp.get(0));
        assertEquals("STANDARD", editCamp.get(1));
        assertEquals("REMOVED", editCamp.get(2));
    }

    @Test (priority = 4)
    public void duplicateCampaigns() throws JSONException {
        ArrayList<String> copyCamp = new CampaignSPK().CopyCampaigns();
        assertTrue(copyCamp.get(0).contains("copy_"));
        assertEquals("DRAFT", copyCamp.get(1));
    }

    @Test (priority = 5)
    public void successCreateNoSPK() throws JSONException {
        ArrayList<String> campaign = new CampaignStandard().CreateCampaigns();
        assertEquals("CampaignTest", campaign.get(0));
        assertEquals("STANDARD", campaign.get(1));
    }

    @Test (priority = 6)
    public void editCampaignsNoSPK() throws JSONException {
        ArrayList<String> campaign = new CampaignStandard().EditCampaigns();
        assertEquals("CampaignSPKEdit", campaign.get(0));
        assertEquals("SPK", campaign.get(1));
    }
}

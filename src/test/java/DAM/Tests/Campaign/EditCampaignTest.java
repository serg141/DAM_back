package DAM.Tests.Campaign;

import DAM.Helper.Campaigns.EditCampaignNoSPK;
import DAM.Helper.Campaigns.EditCampaignSPK;
import org.json.JSONException;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class EditCampaignTest {

    @Test
    public void putCampaignsToNoSPK() throws JSONException {
        ArrayList<String> editCamp = new EditCampaignSPK().getEditCamp();
        assertEquals("CampaignEdit", editCamp.get(0));
        assertEquals("STANDARD", editCamp.get(1));
    }

    @Test
    public void putCampaignsToSPK() throws JSONException {
        ArrayList<String> editCamp = new EditCampaignNoSPK().getEditCamp();
        assertEquals("CampaignSPKEdit", editCamp.get(0));
        assertEquals("SPK", editCamp.get(1));
    }
}

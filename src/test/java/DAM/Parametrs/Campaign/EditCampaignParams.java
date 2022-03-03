package DAM.Parametrs.Campaign;

import DAM.Parametrs.GetDate;
import org.json.JSONException;
import org.json.JSONObject;

public class EditCampaignParams {
    final JSONObject campaignNoSPK = new JSONObject();
    final JSONObject campaignSPK = new JSONObject();
    final JSONObject period = new JSONObject();
    Long start;

    public EditCampaignParams() throws JSONException {
        start = new GetDate().getPlusOneDay();

        period.put("start", start);

        campaignNoSPK.put("name", "CampaignEdit");
        campaignNoSPK.put("type", "STANDARD");
        campaignNoSPK.put("priority", 50);
        campaignNoSPK.put("period", period);

        campaignSPK.put("name", "CampaignSPKEdit");
        campaignSPK.put("type", "SPK");
        campaignSPK.put("priority", 50);
        campaignSPK.put("period", period);
    }

    public String getCampaignNoSPK() {
        return campaignNoSPK.toString();
    }

    public String getCampaignSPK() {
        return campaignSPK.toString();
    }
}

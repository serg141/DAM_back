package DAM.Parametrs.Campaign;

import DAM.Parametrs.GetDate;
import org.json.JSONException;
import org.json.JSONObject;

public class CampaignParams {
    final JSONObject campaignNoSPK = new JSONObject();
    final JSONObject campaignSPK = new JSONObject();
    final JSONObject period = new JSONObject();
    final Long start;

    public CampaignParams() throws JSONException {
        start = new GetDate().getCurrentDate();

        period.put("start", start);

        campaignNoSPK.put("name", "CampaignTest");
        campaignNoSPK.put("type", "STANDARD");
        campaignNoSPK.put("priority", 40);
        campaignNoSPK.put("period", period);

        campaignSPK.put("name", "CampaignSPK");
        campaignSPK.put("type", "SPK");
        campaignSPK.put("priority", 40);
        campaignSPK.put("period", period);
    }

    public String getCampaignNoSPK() {
        return campaignNoSPK.toString();
    }

    public String getCampaignSPK() {
        return campaignSPK.toString();
    }

    public Long getStart() {
        return start;
    }
}

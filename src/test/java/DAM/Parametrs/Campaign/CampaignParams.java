package DAM.Parametrs.Campaign;

import DAM.Parametrs.GetDate;
import lombok.Data;
import org.json.JSONException;
import org.json.JSONObject;

@Data
public class CampaignParams {
    private final JSONObject campaignNoSPK = new JSONObject();
    private final JSONObject campaignSPK = new JSONObject();

    private final JSONObject campaignForFlight = new JSONObject();

    public CampaignParams() throws JSONException {
        Long start = new GetDate().getCurrentDate();
        JSONObject period = new JSONObject();
        period.put("start", start);

        campaignNoSPK.put("name", "CampaignTest");
        campaignNoSPK.put("type", "STANDARD");
        campaignNoSPK.put("priority", 40);
        campaignNoSPK.put("period", period);

        campaignSPK.put("name", "CampaignSPK");
        campaignSPK.put("type", "SPK");
        campaignSPK.put("priority", 40);
        campaignSPK.put("period", period);

        campaignForFlight.put("name", "CampaignForFlight");
        campaignForFlight.put("type", "STANDARD");
        campaignForFlight.put("priority", 40);
        campaignForFlight.put("period", period);
    }
}

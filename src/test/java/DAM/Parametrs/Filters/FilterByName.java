package DAM.Parametrs.Filters;

import lombok.Data;
import org.json.JSONException;
import org.json.JSONObject;

@Data
public class FilterByName {
    private final JSONObject body = new JSONObject();
    private final JSONObject body1 = new JSONObject();
    private final JSONObject body2 = new JSONObject();

    public FilterByName() throws JSONException {
        body.put("nameContains", "CampaignSPK");
        body1.put("nameContains", "CampaignForFlight");
        body2.put("nameContains", "075039d1-ba51-40ea-81b3-f5b1a09ab385");
    }
}

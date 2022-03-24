package DAM.Parametrs.Filters;

import org.json.JSONException;
import org.json.JSONObject;

public class FilterByName {
    private final JSONObject body = new JSONObject();

    public FilterByName() throws JSONException {
        body.put("nameContains", "CampaignSPK");
    }

    public String getBody() {
        return body.toString();
    }
}

package DAM.Parametrs.Filters;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FilterFlightStatusModerationClaimed {
    final JSONObject filter = new JSONObject();

    public FilterFlightStatusModerationClaimed() throws JSONException {
        JSONArray status = new JSONArray();

        status.put("MODERATION_CLAIMED");

        filter.put("flightStatuses", status);
    }

    public String getFilter() {
        return filter.toString();
    }
}

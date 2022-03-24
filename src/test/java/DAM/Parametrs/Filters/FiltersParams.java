package DAM.Parametrs.Filters;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FiltersParams {
    final JSONObject filter = new JSONObject();

    public FiltersParams() throws JSONException {
        JSONArray statuses = new JSONArray();
        JSONArray flightStatuses = new JSONArray();

        statuses.put("ACTIVE");
        statuses.put("FINISHED");
        flightStatuses.put("PENDING");
        flightStatuses.put("ACTIVE");

        filter.put("statuses", statuses);
        filter.put("nameContains", "Campaign");
        filter.put("flightStatuses", flightStatuses);
    }

    public String getFilter() {
        return filter.toString();
    }
}

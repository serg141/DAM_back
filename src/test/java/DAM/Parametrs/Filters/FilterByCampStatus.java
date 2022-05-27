package DAM.Parametrs.Filters;

import lombok.Data;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Data
public class FilterByCampStatus {
    private final JSONObject body1 = new JSONObject();
    private final JSONObject body2 = new JSONObject();
    private final JSONObject body3 = new JSONObject();
    private final JSONObject body4 = new JSONObject();

    public FilterByCampStatus() throws JSONException {
        JSONArray statuses1 = new JSONArray();
        statuses1.put("DRAFT");
        body1.put("statuses", statuses1);

        JSONArray statuses2 = new JSONArray();
        statuses2.put("ACTIVE");
        body2.put("statuses", statuses2);

        JSONArray statuses3 = new JSONArray();
        statuses3.put("FINISHED");
        body3.put("statuses", statuses3);

        JSONArray statuses4 = new JSONArray();
        statuses4.put("REMOVED");
        body4.put("statuses", statuses4);
    }
}

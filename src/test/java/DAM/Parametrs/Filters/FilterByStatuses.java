package DAM.Parametrs.Filters;

import lombok.Data;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Data
public class FilterByStatuses {
    private final JSONObject body = new JSONObject();

    public FilterByStatuses() throws JSONException {
        JSONArray statuses = new JSONArray();
        statuses.put("ACTIVE");
        statuses.put("FINISHED");

        JSONArray flightStatuses = new JSONArray();
        flightStatuses.put("PAUSED");
        flightStatuses.put("ACTIVE");

        body.put("statuses", statuses);
        body.put("flightStatuses", flightStatuses);
    }
}

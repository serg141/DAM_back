package DAM.Parametrs.Filters;

import lombok.Data;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Data
public class FilterByFlightStatus {
    private final JSONObject body1 = new JSONObject();
    private final JSONObject body2 = new JSONObject();
    private final JSONObject body3 = new JSONObject();
    private final JSONObject body4 = new JSONObject();
    private final JSONObject body5 = new JSONObject();
    private final JSONObject body6 = new JSONObject();
    private final JSONObject body7 = new JSONObject();
    private final JSONObject body8 = new JSONObject();

    public FilterByFlightStatus() throws JSONException {
        JSONArray statuses1 = new JSONArray();
        statuses1.put("ACTIVE");
        body1.put("flightStatuses", statuses1);

        JSONArray statuses2 = new JSONArray();
        statuses2.put("DECLINED");
        body2.put("flightStatuses", statuses2);

        JSONArray statuses3 = new JSONArray();
        statuses3.put("PAUSED");
        body3.put("flightStatuses", statuses3);

        JSONArray statuses4 = new JSONArray();
        statuses4.put("PENDING");
        body4.put("flightStatuses", statuses4);

        JSONArray statuses5 = new JSONArray();
        statuses5.put("MODERATION_CLAIMED");
        body5.put("flightStatuses", statuses5);

        body6.put("nameContains", "DRAFT");

        JSONArray statuses7 = new JSONArray();
        statuses7.put("FINISHED");
        body7.put("flightStatuses", statuses7);

        JSONArray statuses8 = new JSONArray();
        statuses8.put("REMOVED");
        body8.put("flightStatuses", statuses8);
    }
}

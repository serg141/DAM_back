package DAM.Parametrs.Filters;

import DAM.Parametrs.GetDate;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FiltersParams {
    final JSONObject filter = new JSONObject();
    Long start, end;

    public FiltersParams() throws JSONException {
        JSONArray statuses = new JSONArray();
        JSONArray flightStatuses = new JSONArray();

        statuses.put("ACTIVE");
        statuses.put("FINISHED");
        flightStatuses.put("PENDING");
        flightStatuses.put("ACTIVE");

        start = new GetDate().getMinusOneMonth();
        end = new GetDate().getPlusOneYear();

        filter.put("statuses", statuses);
        filter.put("nameContains", "Campaign");
        filter.put("flightStatuses", flightStatuses);
        //filter.put("start", start);
        //filter.put("end", end);
    }

    public String getFilter() {
        return filter.toString();
    }
}

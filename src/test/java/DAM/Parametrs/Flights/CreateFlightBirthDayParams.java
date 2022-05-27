package DAM.Parametrs.Flights;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CreateFlightBirthDayParams {
    final JSONObject flight = new JSONObject();
    final JSONObject segmentIdsMap = new JSONObject();

    public CreateFlightBirthDayParams() throws JSONException {
        JSONArray specialParams = new JSONArray();
        specialParams.put("ageAll");
        specialParams.put("genderAll");

        segmentIdsMap.put("cd424eb2-8c49-4097-9941-24626996fb6d", true);

        flight.put("specialParams", specialParams);
        flight.put("segmentIdsMap", segmentIdsMap);
    }

    public String getFlight() {
        return flight.toString();
    }
}

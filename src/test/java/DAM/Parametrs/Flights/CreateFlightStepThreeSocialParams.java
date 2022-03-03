package DAM.Parametrs.Flights;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CreateFlightStepThreeSocialParams {
    final JSONObject flight = new JSONObject();
    final JSONObject segmentIdsMap = new JSONObject();

    public CreateFlightStepThreeSocialParams() throws JSONException {
        JSONArray specialParams = new JSONArray();
        specialParams.put("ageAll");
        specialParams.put("genderAll");

        segmentIdsMap.put("26a42f93-7499-4c4a-9fee-0cfba8309d15", true);

        flight.put("specialParams", specialParams);
        flight.put("segmentIdsMap", segmentIdsMap);
    }

    public String getFlight() {
        return flight.toString();
    }
}

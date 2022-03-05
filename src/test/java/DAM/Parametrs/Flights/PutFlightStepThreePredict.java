package DAM.Parametrs.Flights;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PutFlightStepThreePredict {
    final JSONObject flight = new JSONObject();
    final JSONObject segmentIdsMap = new JSONObject();

    public PutFlightStepThreePredict() throws JSONException {
        JSONArray specialParams = new JSONArray();
        specialParams.put("ageAll");
        specialParams.put("genderAll");

        flight.put("specialParams", specialParams);
        flight.put("segmentIdsMap", segmentIdsMap);
    }

    public String getFlight() {
        return flight.toString();
    }
}

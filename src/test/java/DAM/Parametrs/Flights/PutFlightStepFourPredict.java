package DAM.Parametrs.Flights;

import org.json.JSONException;
import org.json.JSONObject;

public class PutFlightStepFourPredict {
    final JSONObject flight = new JSONObject();
    final JSONObject segmentIdsMap = new JSONObject();

    public PutFlightStepFourPredict() throws JSONException {
        flight.put("segmentIdsMap", segmentIdsMap);
    }

    public String getFlight() {
        return flight.toString();
    }
}

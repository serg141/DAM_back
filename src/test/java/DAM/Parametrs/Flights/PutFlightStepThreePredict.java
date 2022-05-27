package DAM.Parametrs.Flights;

import lombok.Data;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Data
public class PutFlightStepThreePredict {
    final JSONObject flight = new JSONObject();

    public PutFlightStepThreePredict() throws JSONException {
        JSONObject segmentIdsMap = new JSONObject();
        JSONArray specialParams = new JSONArray();
        specialParams.put("ageAll");
        specialParams.put("genderAll");

        flight.put("specialParams", specialParams);
        flight.put("segmentIdsMap", segmentIdsMap);
    }
}

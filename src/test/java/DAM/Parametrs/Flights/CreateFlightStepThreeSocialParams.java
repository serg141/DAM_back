package DAM.Parametrs.Flights;

import lombok.Data;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Data
public class CreateFlightStepThreeSocialParams {
    final JSONObject flight = new JSONObject();

    public CreateFlightStepThreeSocialParams() throws JSONException {
        JSONArray specialParams = new JSONArray();
        specialParams.put("ageAll");
        specialParams.put("genderAll");

        JSONObject segmentIdsMap = new JSONObject();
        segmentIdsMap.put("26a42f93-7499-4c4a-9fee-0cfba8309d15", true);

        flight.put("specialParams", specialParams);
        flight.put("segmentIdsMap", segmentIdsMap);
    }
}

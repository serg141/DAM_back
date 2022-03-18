package DAM.Parametrs.Flights;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PutFlightStepFourPredict {
    final JSONObject flight = new JSONObject();

    public PutFlightStepFourPredict() throws JSONException {
        JSONObject filters = new JSONObject();
        filters.put("fromAppVer", "15.4.0");
        filters.put("toAppVer", "15.4.2");

        JSONObject apple = new JSONObject();
        apple.put("categoryUuid", "64c2f22d-7566-48b3-a9cb-af11f1868494");
        apple.put("filters", filters);

        JSONArray selections = new JSONArray();
        selections.put(apple);

        JSONObject segmentIdsMap = new JSONObject();
        segmentIdsMap.put("502c85c4-bb22-4071-9590-86d5b122696a", true);
        segmentIdsMap.put("66f04a9c-1e63-4583-8137-bfa016f4f7d6", false);

        flight.put("selections", selections);
        flight.put("segmentIdsMap", segmentIdsMap);
    }

    public String getFlight() {
        return flight.toString();
    }
}

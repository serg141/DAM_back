package DAM.Parametrs.Flights;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CreateFlightStepFourTechParams {
    final JSONObject flightWithOutParameters = new JSONObject();
    final JSONObject flightWithParameters = new JSONObject();
    final JSONObject segmentIdsMap1 = new JSONObject();
    final JSONObject segmentIdsMap2 = new JSONObject();
    final JSONObject version1 = new JSONObject();
    final JSONObject version2 = new JSONObject();
    final JSONObject filter = new JSONObject();

    public CreateFlightStepFourTechParams() throws JSONException {
        flightWithOutParameters.put("segmentIdsMap", segmentIdsMap1);

        filter.put("fromAppVer", "15.4.0");
        filter.put("toAppVer", "15.4.2");

        version1.put("categoryUuid", "64c2f22d-7566-48b3-a9cb-af11f1868494");
        version1.put("filters", filter);
        version2.put("categoryUuid", "a27c47b7-500f-48d9-b4ff-517451c9c17e");
        version2.put("filters", filter);

        JSONArray selections = new JSONArray();
        selections.put(version1);
        selections.put(version2);

        segmentIdsMap2.put("6b9abca0-6c55-4851-8cc5-bec56814510b", true);
        segmentIdsMap2.put("f177e59d-102a-4364-be9f-35edefc15813", true);
        segmentIdsMap2.put("502c85c4-bb22-4071-9590-86d5b122696a", true);
        segmentIdsMap2.put("66f04a9c-1e63-4583-8137-bfa016f4f7d6", false);
        segmentIdsMap2.put("9cab5e85-b6bd-4fe3-a4ab-2df010c554c3", false);

        flightWithParameters.put("segmentIdsMap", segmentIdsMap2);
        flightWithParameters.put("selections", selections);
    }

    public String getFlightWithOutParameters() {
        return flightWithOutParameters.toString();
    }

    public String getFlightWithParameters() {
        return flightWithParameters.toString();
    }
}

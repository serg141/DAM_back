package DAM.Parametrs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CreateFlightStepTwoParams {
    final JSONObject flight = new JSONObject();
    final JSONObject location = new JSONObject();
    final JSONObject position = new JSONObject();
    final JSONObject format = new JSONObject();

    public CreateFlightStepTwoParams() throws JSONException {
        format.put("id", "1721cf87-f07c-496a-8c29-2eb8a3cc15b0");
        JSONArray formats = new JSONArray();
        formats.put(format);

        position.put("id", "89a2018f-55e8-4ac3-930e-006867a9c3ca");
        position.put("formats", formats);
        JSONArray positions = new JSONArray();
        positions.put(position);

        location.put("id", "038edcaf-2d19-4dfa-9c09-3ed09a9f4e5a");
        location.put("positions", positions);
        JSONArray locations = new JSONArray();
        locations.put(location);

        flight.put("id", "c6535841-1989-4287-8c5e-51c30830c562");
        flight.put("locations", locations);
    }

    public String getFlight() {
        return flight.toString();
    }
}

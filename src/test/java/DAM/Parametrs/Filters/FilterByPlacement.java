package DAM.Parametrs.Filters;

import lombok.Data;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Data
public class FilterByPlacement {
    private final JSONObject body = new JSONObject();

    public FilterByPlacement() throws JSONException {
        JSONObject id = new JSONObject();
        id.put("id", "1721cf87-f07c-496a-8c29-2eb8a3cc15b0");

        JSONArray formats = new JSONArray();
        formats.put(id);

        JSONObject pos = new JSONObject();
        pos.put("formats", formats);
        pos.put("id", "89a2018f-55e8-4ac3-930e-006867a9c3ca");

        JSONArray positions = new JSONArray();
        positions.put(pos);

        JSONObject loc = new JSONObject();
        loc.put("id", "038edcaf-2d19-4dfa-9c09-3ed09a9f4e5a");
        loc.put("positions", positions);

        JSONArray locations = new JSONArray();
        locations.put(loc);

        JSONObject channel = new JSONObject();
        channel.put("id", "c6535841-1989-4287-8c5e-51c30830c562");
        channel.put("locations", locations);

        body.put("placement", channel);
    }
}

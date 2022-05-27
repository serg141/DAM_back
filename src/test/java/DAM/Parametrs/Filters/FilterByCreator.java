package DAM.Parametrs.Filters;

import lombok.Data;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Data
public class FilterByCreator {
    private final JSONObject body = new JSONObject();

    public FilterByCreator() throws JSONException {
        JSONArray creatorIds = new JSONArray();
        creatorIds.put("84a7aa7d-336b-4fa4-a883-b7ebc83d7d80");
        body.put("creatorIds", creatorIds);
    }
}

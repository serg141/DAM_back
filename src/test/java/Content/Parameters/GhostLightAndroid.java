package Content.Parameters;

import lombok.Data;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;

@Data
public class GhostLightAndroid {
    private final JSONObject body = new JSONObject();

    public GhostLightAndroid() throws JSONException {
        LocalDate dateTime = LocalDate.now();

        JSONObject pos = new JSONObject();
        pos.put("positionName", "GHOST");
        pos.put("positionCount", 1);
        JSONArray position = new JSONArray();
        position.put(pos);

        JSONObject loc = new JSONObject();
        loc.put("locationName", "MAIN_PAGE");
        loc.put("positions", position);
        JSONArray locations = new JSONArray();
        locations.put(loc);

        JSONObject device = new JSONObject();
        device.put("contextType", "MobileContext");
        device.put("platformType", "ANDROID");
        device.put("manufacturer", "Google");
        device.put("deviceModel", "GGGG");
        device.put("osVersion", "11");
        device.put("mobileVersion", "15.4.0");
        device.put("theme", "lightTheme");

        JSONObject context = new JSONObject();
        context.put("channelName", "MOBILE");
        context.put("device", device);

        body.put("requestId", "07516d6f-c082-42c5-9c95-2d9a726cfe69");
        body.put("timestamp", dateTime + "T21:36:04.218+03:00");
        body.put("context", context);
        body.put("locations", locations);
    }
}

package DAM.Parametrs.Moderation;

import DAM.Helper.Flights.CreateFlightStepSix;
import lombok.Data;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

@Data
public class SendToModeration {
    ArrayList<String> idList = new ArrayList<>();

    public SendToModeration() throws JSONException {
        String id = new CreateFlightStepSix().getFlightStepSix().get(13);

        JSONArray flight = new JSONArray();
        flight.put(id);
        idList.add(flight.toString());
        idList.add(id);
    }
}

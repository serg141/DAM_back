package DAM.Parametrs.Moderation;

import DAM.Helper.Flights.CreateFlights;
import lombok.Data;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

@Data
public class SendToModeration {
    ArrayList<String> idList = new ArrayList<>();

    public SendToModeration() throws JSONException {
        String id = new CreateFlights().CreateStepSix().get(12);

        JSONArray flight = new JSONArray();
        flight.put(id);
        idList.add(flight.toString());
        idList.add(id);
    }
}

package DAM.Parametrs.Moderation;

import DAM.Helper.Flights.CreateFlightStepSix;
import org.json.JSONArray;
import org.json.JSONException;

public class SendToModeration {
    String[] idList;

    public SendToModeration() throws JSONException {
        idList = new String[2];
        String id = new CreateFlightStepSix().getFlightStepSix()[13];

        JSONArray flight = new JSONArray();
        flight.put(id);
        idList[0] = flight.toString();
        idList[1] = id;
    }

    public String[] getIdList() {
        return idList;
    }
}

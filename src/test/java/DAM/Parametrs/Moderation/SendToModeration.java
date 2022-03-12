package DAM.Parametrs.Moderation;

import DAM.Flights.CreateFlightStepSix;
import DAM.LogIn;
import org.json.JSONArray;
import org.json.JSONException;

public class SendToModeration {
    String logIn, id;
    JSONArray flight = new JSONArray();
    String[] idList;

    public SendToModeration() throws JSONException {
        idList = new String[2];
        logIn = new LogIn().logIn();
        id = new CreateFlightStepSix().getId();

        flight.put(id);
        idList[0] = flight.toString();
        idList[1] = id;
    }

    public String[] getIdList() {
        return idList;
    }
}

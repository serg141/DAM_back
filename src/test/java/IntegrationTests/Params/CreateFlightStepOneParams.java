package IntegrationTests.Params;

import DAM.Parametrs.GetDate;
import IntegrationTests.CreateCampaign.CreateCampaign;
import org.json.JSONException;
import org.json.JSONObject;

public class CreateFlightStepOneParams {
    final JSONObject flight = new JSONObject();
    final JSONObject period = new JSONObject();

    public CreateFlightStepOneParams() throws JSONException {
        Long start = new GetDate().getCurrentDate();
        String campaignId = new CreateCampaign().getCampaignId();

        period.put("start", start);

        JSONObject frequency = new JSONObject();
        frequency.put("term", "DAILY");
        frequency.put("value", 1);

        flight.put("name", "FlightTest");
        flight.put("campaignId", campaignId);
        flight.put("purpose", "STANDARD");
        flight.put("frequency", frequency);
        flight.put("priority", 40);
        flight.put("period", period);
    }

    public String getFlight() {
        return flight.toString();
    }
}

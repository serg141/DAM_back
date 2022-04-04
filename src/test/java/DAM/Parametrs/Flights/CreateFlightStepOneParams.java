package DAM.Parametrs.Flights;

import DAM.Helper.Campaigns.CreateCampaignForFlight;
import DAM.Helper.Flights.DownloadBrief;
import DAM.Parametrs.GetDate;
import org.json.JSONException;
import org.json.JSONObject;

public class CreateFlightStepOneParams {
    final JSONObject flight = new JSONObject();
    final JSONObject period = new JSONObject();
    final JSONObject frequency = new JSONObject();

    public CreateFlightStepOneParams() throws JSONException {
        String briefId = new DownloadBrief().getBriefName().get(1);
        Long start = new GetDate().getCurrentDate();
        Long end = new GetDate().getPlusOneMonth();
        String campaignId = new CreateCampaignForFlight().getId();

        period.put("start", start);
        period.put("end", end);

        frequency.put("term", "DAILY");
        frequency.put("value", 1);

        flight.put("name", "FlightTest");
        flight.put("campaignId", campaignId);
        flight.put("purpose", "STANDARD");
        flight.put("frequency", frequency);
        flight.put("priority", 40);
        flight.put("period", period);
        flight.put("briefId", briefId);
    }

    public String getFlight() {
        return flight.toString();
    }
}

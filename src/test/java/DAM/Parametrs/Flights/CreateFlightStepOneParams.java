package DAM.Parametrs.Flights;

import DAM.Helper.Campaigns.CampaignStandard;
import DAM.Helper.Flights.Brief;
import DAM.Parametrs.GetDate;
import lombok.Data;
import org.json.JSONException;
import org.json.JSONObject;

@Data
public class CreateFlightStepOneParams {
    final JSONObject flight = new JSONObject();

    public CreateFlightStepOneParams() throws JSONException {
        String briefId = new Brief().DownloadBrief().get(1);
        Long start = new GetDate().getCurrentDate();
        Long end = new GetDate().getPlusOneMonth();
        String campaignId = new CampaignStandard().CreateCampaigns().get(2);

        JSONObject period = new JSONObject();
        period.put("start", start);
        period.put("end", end);

        JSONObject frequency = new JSONObject();
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
}

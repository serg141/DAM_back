package DAM.Tests.Flight.Predict;

import DAM.Predict.GetPredictByFlight;
import org.json.JSONException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetPredictByFlightTest {

    @Test
    public void getPredict() throws JSONException {
        int predict = new GetPredictByFlight().getPredict();

        assertEquals(1, predict);
    }
}

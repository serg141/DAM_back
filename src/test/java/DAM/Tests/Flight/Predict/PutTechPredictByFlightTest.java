package DAM.Tests.Flight.Predict;

import DAM.Predict.PutTechPredictByFlight;
import org.json.JSONException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PutTechPredictByFlightTest {

    @Test
    public void putPredictTech() throws JSONException {
        assertEquals(1, new PutTechPredictByFlight().getPredict());
    }
}

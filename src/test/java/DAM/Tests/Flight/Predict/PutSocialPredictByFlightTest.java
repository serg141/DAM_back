package DAM.Tests.Flight.Predict;

import DAM.Predict.PutSocialPredictByFlight;
import org.json.JSONException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PutSocialPredictByFlightTest {

    @Test
    public void putPredictSocial() throws JSONException {

        int i = new PutSocialPredictByFlight().getPredict();
        assertEquals(10000000, i);
    }
}

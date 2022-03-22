package DAM.Tests.Flight.Predict;

import DAM.Helper.Predict.GetPredict;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetPredictByFlightTest {
    int[] predict;

    @Before
    public void GetPredict() throws JSONException {
        predict = new GetPredict().getPredict();
    }

    @Test
    public void getPredictByFlightTest() {
        assertEquals(1, predict[0]);
    }

    @Test
    public void putSocialPredictTest() {
        assertEquals(1, predict[1]);
    }

    @Test
    public void putTechPredictTest() {
        assertEquals(1, predict[2]);
    }
}

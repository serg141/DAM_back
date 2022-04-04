package DAM.Tests.Flight.Predict;

import DAM.Helper.Predict.PredictFlight;
import org.json.JSONException;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GetPredictByFlightTest {

    @Test
    public void getPredictByFlightTest() throws JSONException {
        ArrayList<Integer> predict = new PredictFlight().getPredict();

        assertEquals(1, predict.get(0).intValue());
        assertEquals(1, predict.get(1).intValue());
        assertEquals(1, predict.get(2).intValue());
    }
}

package DAM.Tests.Flight;

import DAM.Helper.Flights.PredictFlight;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GetPredictByFlightTest {

    @Test(priority = 1)
    public void getPredictByFlightStepThreeTest() throws JSONException {
        ArrayList<Integer> predict = new PredictFlight().PredictFlightStepThreeAuth();

        assertEquals(0, predict.get(0).intValue());
        assertEquals(10000000, predict.get(1).intValue());
    }

    @Test (priority = 2)
    public void getPredictByFlightStepFourTest() throws JSONException {
        ArrayList<Integer> predict = new PredictFlight().PredictFlightStepFourTech();

        assertEquals(0, predict.get(0).intValue());
        assertEquals(0, predict.get(1).intValue());
    }
}

package Content.BirthDayTest;

import Content.Helper.ContentRequest;
import Content.Parameters.BirthDayGhostLight;
import Content.Helper.FindFlightIdInActivator;
import org.json.JSONException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class BirthdayTest {
    String content, idFlight;

    @BeforeTest
    public void receiveData() throws JSONException {
        String body = new BirthDayGhostLight().getBody().toString();
        idFlight = new FindFlightIdInActivator().Birthday();
        content = new ContentRequest(body).getContent();
    }

    @Test
    public void BirthDay() {
        assertEquals(content, idFlight);
        //System.out.println(content + " " + idFlight);
    }
}

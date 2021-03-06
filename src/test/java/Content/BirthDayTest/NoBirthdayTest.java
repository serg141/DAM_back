package Content.BirthDayTest;

import Content.Helper.ContentRequest;
import Content.Parameters.PrerollLightIOS;
import Content.Helper.FindFlightIdInActivator;
import org.json.JSONException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertNotEquals;

public class NoBirthdayTest {
    String content, idFlight;

    @BeforeTest
    public void receiveData() throws JSONException {
        String body = new PrerollLightIOS().getBody().toString();
        idFlight = new FindFlightIdInActivator().Birthday();
        content = new ContentRequest(body).getContent();
    }
    
    @Test
    public void NoBirthDay() {
        assertNotEquals(content, idFlight);
        //System.out.println(content + " " + idFlight);
    }
}

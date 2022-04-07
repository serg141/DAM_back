package Content.VersionControl;

import Content.Helper.ContentRequest;
import Content.Parameters.OnlyIOSPrerollLight;
import Integration.ActivatorOnlyAndroid;
import org.json.JSONException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertNotEquals;

public class NotOnlyAndroidTest {
    String content, idFlight;

    @BeforeTest
    public void receiveData() throws JSONException {
        String body = new OnlyIOSPrerollLight().getBody().toString();
        idFlight = new ActivatorOnlyAndroid().getFlightId();
        content = new ContentRequest(body).getContent();
    }

    @Test
    public void NotOnlyAndroid() {
        assertNotEquals(idFlight, content);
        //System.out.println(content + " " + idFlight);
    }
}

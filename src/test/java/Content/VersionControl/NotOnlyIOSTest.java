package Content.VersionControl;

import Content.Helper.ContentRequest;
import Content.Parameters.OnlyAndroidPrerollLight;
import Integration.ActivatorOnlyIOS;
import org.json.JSONException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertNotEquals;

public class NotOnlyIOSTest {
    String content, idFlight;

    @BeforeTest
    public void receiveData() throws JSONException {
        String body = new OnlyAndroidPrerollLight().getBody().toString();
        idFlight = new ActivatorOnlyIOS().getFlightId();
        content = new ContentRequest(body).getContent();
    }

    @Test
    public void NotOnlyIOS() {
        assertNotEquals(idFlight, content);
        //System.out.println(content + " " + idFlight);
    }
}

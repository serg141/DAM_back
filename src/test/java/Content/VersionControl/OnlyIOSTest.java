package Content.VersionControl;

import Content.Helper.ContentRequest;
import Content.Parameters.OnlyIOSPrerollLight;
import Integration.ActivatorOnlyIOS;
import org.json.JSONException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class OnlyIOSTest {
    String content, idFlight;

    @BeforeTest
    public void receiveData() throws JSONException {
        String body = new OnlyIOSPrerollLight().getBody().toString();
        idFlight = new ActivatorOnlyIOS().getFlightId();
        content = new ContentRequest(body).getContent();
    }

    @Test
    public void OnlyIOS() {
        assertEquals(idFlight, content);
        //System.out.println(content + " " + idFlight);
    }
}

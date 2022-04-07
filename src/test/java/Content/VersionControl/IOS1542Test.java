package Content.VersionControl;

import Content.Helper.ContentRequest;
import Content.Parameters.GhostLightIOS1542;
import Integration.ActivatorIOS1542;
import org.json.JSONException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class IOS1542Test {
    String content, idFlight;

    @BeforeTest
    public void receiveData() throws JSONException {
        String body = new GhostLightIOS1542().getBody().toString();
        idFlight = new ActivatorIOS1542().getFlightId();
        content = new ContentRequest(body).getContent();
    }

    @Test
    public void IOS1542() {
        assertEquals(idFlight, content);
        //System.out.println(content + " " + idFlight);
    }
}

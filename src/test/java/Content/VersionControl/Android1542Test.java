package Content.VersionControl;

import Content.Helper.ContentRequest;
import Content.Parameters.GhostLightAndroid1542;
import Integration.ActivatorAndroid1542;
import org.json.JSONException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class Android1542Test {
    String content, idFlight;

    @BeforeTest
    public void receiveData() throws JSONException {
        String body = new GhostLightAndroid1542().getBody().toString();
        idFlight = new ActivatorAndroid1542().getFlightId();
        content = new ContentRequest(body).getContent();
    }

    @Test
    public void Android1542() {
        assertEquals(idFlight, content);
        //System.out.println(content + " " + idFlight);
    }
}

package Content.VersionControlTest;

import Content.Helper.ContentRequest;
import Content.Parameters.GhostLightIOS1542;
import Content.Helper.FindFlightIdInActivator;
import org.json.JSONException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class IOS1542Test {
    String content, idFlight;

    @BeforeTest
    public void receiveData() throws JSONException {
        String body = new GhostLightIOS1542().getBody().toString();
        idFlight = new FindFlightIdInActivator().IOS1542();
        content = new ContentRequest(body).getContent();
    }

    @Test
    public void IOS1542() {
        assertEquals(idFlight, content);
        //System.out.println(content + " " + idFlight);
    }
}

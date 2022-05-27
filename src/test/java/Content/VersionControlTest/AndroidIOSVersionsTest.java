package Content.VersionControlTest;

import Content.Helper.ContentRequest;
import Content.Parameters.GhostDarkAndroid;
import Content.Parameters.GhostDarkIOS;
import Content.Helper.FindFlightIdInActivator;
import org.json.JSONException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class AndroidIOSVersionsTest {
    String idFlight, content1, content2;

    @BeforeTest
    public void receiveData() throws JSONException {
        String body1 = new GhostDarkIOS().getBody().toString();
        String body2 = new GhostDarkAndroid().getBody().toString();
        idFlight = new FindFlightIdInActivator().IOSAndroidVersions();
        content1 = new ContentRequest(body1).getContent();
        content2 = new ContentRequest(body2).getContent();
    }

    @Test
    public void IOS() {
        assertEquals(idFlight, content1);
        //System.out.println(content1 + " " + idFlight);
    }

    @Test
    public void Android() {
        assertEquals(idFlight, content2);
        //System.out.println(content2 + " " + idFlight);
    }
}

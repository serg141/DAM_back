package Content.VersionControl;

import Content.Helper.ContentRequest;
import Content.Parameters.OnlyAndroidPrerollLight;
import Integration.ActivatorOnlyAndroid;
import org.json.JSONException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class OnlyAndroidTest {
    String content, idFlight;

    @BeforeTest
    public void receiveData() throws JSONException {
        String body = new OnlyAndroidPrerollLight().getBody().toString();
        idFlight = new ActivatorOnlyAndroid().getFlightId();
        content = new ContentRequest(body).getContent();
    }

    @Test
    public void OnlyAndroid() {
        assertEquals(idFlight, content);
        //System.out.println(content + " " + idFlight);
    }
}

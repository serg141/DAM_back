package Example;

import Content.Parameters.OnlyIOSPrerollLight;
import Integration.ActivatorOnlyIOS;
import org.json.JSONException;

import static org.junit.Assert.assertEquals;

public class OnlyIOSTest11 {
    String content;
    String idFight;


    public void receiveFlightId() throws JSONException {
        String body = new OnlyIOSPrerollLight().getBody().toString();
        content = String.valueOf(new Test1(body));
        idFight = new ActivatorOnlyIOS().getFlightId();
    }

    public void OnlyIOS() {
        assertEquals(idFight, content);
    }
}

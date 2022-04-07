package Content.MoneyBox;

import Content.Helper.ContentRequest;
import Content.Parameters.PrerollDarkIOS;
import Integration.ActivatorMoneyBox;
import org.json.JSONException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertNotEquals;

public class NoMoneyBoxTest {
    String content, idFlight;

    @BeforeTest
    public void receiveData() throws JSONException {
        String body = new PrerollDarkIOS().getBody().toString();
        idFlight = new ActivatorMoneyBox().getFlightId();
        content = new ContentRequest(body).getContent();
    }

    @Test
    public void NoMoneyBox() {
        assertNotEquals(idFlight, content);
        //System.out.println(content + " " + idFlight);
    }
}

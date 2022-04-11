package Content.MoneyBoxTest;

import Content.Helper.ContentRequest;
import Content.Parameters.PrerollDarkIOS;
import Content.Helper.FindFlightIdInActivator;
import org.json.JSONException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertNotEquals;

public class NoMoneyBoxTest {
    String content, idFlight;

    @BeforeTest
    public void receiveData() throws JSONException {
        String body = new PrerollDarkIOS().getBody().toString();
        idFlight = new FindFlightIdInActivator().MoneyBox();
        content = new ContentRequest(body).getContent();
    }

    @Test
    public void NoMoneyBox() {
        assertNotEquals(idFlight, content);
        //System.out.println(content + " " + idFlight);
    }
}

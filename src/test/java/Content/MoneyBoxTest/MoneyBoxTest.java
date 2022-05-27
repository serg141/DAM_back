package Content.MoneyBoxTest;

import Content.Helper.ContentRequest;
import Content.Parameters.PrerollDarkIOS;
import Content.Helper.FindFlightIdInActivator;
import org.json.JSONException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MoneyBoxTest {
    ArrayList<String> content = new ArrayList<>();

    @BeforeTest
    public void receiveData() throws JSONException {
        String body = new PrerollDarkIOS().getBody().toString();
        content = new ContentRequest(body).ContentMoneyBox(body);
        content.add(new FindFlightIdInActivator().MoneyBox());
    }

    @Test
    public void MoneyBox() {
        assertEquals(content.get(3), content.get(0));
        assertEquals("Переменная1 100 000", content.get(1));
        assertEquals("Переменная2 10 000", content.get(2));
        //System.out.println(content);
    }
}

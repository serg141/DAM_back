package DAM.Tests.Moderation;

import DAM.Helper.Moderation.Moderation;
import org.json.JSONException;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ModerationTest {

    @Test
    public void SendToModerationTest() throws JSONException {
        ArrayList<String> status = new Moderation().getStatus();
        assertEquals("MODERATION_CLAIMED", status.get(0));
        assertEquals("MODERATION_INPROGRESS", status.get(1));
        assertEquals("MODERATION_CLAIMED", status.get(2));
    }
}

package DAM.Tests.Moderation;

import DAM.Moderation.Moderation;
import org.json.JSONException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ModerationTest {

    @Test
    public void SendToModerationTest() throws JSONException {
        String[] status = new Moderation().getStatus();
        assertEquals("MODERATION_CLAIMED", status[0]);
        assertEquals("MODERATION_INPROGRESS", status[1]);
        assertEquals("MODERATION_CLAIMED", status[2]);
    }
}

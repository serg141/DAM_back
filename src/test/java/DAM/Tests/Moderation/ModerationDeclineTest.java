package DAM.Tests.Moderation;

import DAM.Moderation.ModerationDecline;
import org.json.JSONException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ModerationDeclineTest {

    @Test
    public void moderationDecline() throws JSONException {
        assertEquals("DECLINED", new ModerationDecline().getStatus());
    }
}

package DAM.Tests.Flight;

import DAM.Helper.Flights.ModerationFlight;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ModerationTest {

    @Test (priority = 1)
    public void ModerationCommentsTest() throws JSONException {
        List<String> comment = new ModerationFlight().GetModerationComments();

        for(int i = 0; i < 14; i++) {
            assertEquals("Test" + i, comment.get(i));
        }
    }

    @Test (priority = 2)
    public void ModerationCancelTest() throws JSONException {
        ArrayList<String> status = new ModerationFlight().ModerationCancel();
        assertEquals("MODERATION_CLAIMED", status.get(1));
        assertEquals("MODERATION_INPROGRESS", status.get(0));
    }

    @Test (priority = 3)
    public void ModerationDeclineTest() throws JSONException {
        String status = new ModerationFlight().ModerationDecline();
        assertEquals("DECLINED", status);
    }
}

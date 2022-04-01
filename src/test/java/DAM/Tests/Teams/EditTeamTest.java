package DAM.Tests.Teams;

import DAM.Helper.Teams.PutTeam;
import org.json.JSONException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EditTeamTest {

    @Test
    public void createTeam() throws JSONException {
        assertEquals("NewTeam", new PutTeam().getEditTeam());
    }
}

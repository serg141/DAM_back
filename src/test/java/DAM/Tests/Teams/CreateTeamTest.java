package DAM.Tests.Teams;

import DAM.Helper.Teams.CreateTeam;
import org.json.JSONException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreateTeamTest {

    @Test
    public void createTeam() throws JSONException {
        assertEquals("test", new CreateTeam().getTeam().get(1));
    }
}

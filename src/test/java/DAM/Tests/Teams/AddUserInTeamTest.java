package DAM.Tests.Teams;

import DAM.Helper.Teams.AddUserInTeam;
import org.json.JSONException;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AddUserInTeamTest {

    @Test
    public void postUserRoleRedactor() throws JSONException {
        ArrayList<String> team = new AddUserInTeam().getTeam();

        assertEquals("user1", team.get(0));
        assertEquals("test user one", team.get(1));
        assertEquals("UNASSIGNED", team.get(2));
        assertEquals("test", team.get(3));
        assertEquals("c6535841-1989-4287-8c5e-51c30830c562", team.get(4));
        assertEquals("038edcaf-2d19-4dfa-9c09-3ed09a9f4e5a", team.get(5));
        assertEquals("89a2018f-55e8-4ac3-930e-006867a9c3ca", team.get(6));
        assertEquals("1721cf87-f07c-496a-8c29-2eb8a3cc15b0", team.get(7));
    }
}

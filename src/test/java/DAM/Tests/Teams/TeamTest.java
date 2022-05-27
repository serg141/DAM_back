package DAM.Tests.Teams;

import DAM.Helper.Teams.Team;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TeamTest {

    @Test (priority = 1)
    public void CreateTeamTest() throws JSONException {
        ArrayList<String> team = new Team().CreateTeam();

        assertEquals("test", team.get(0));
        assertEquals("c6535841-1989-4287-8c5e-51c30830c562", team.get(1));
        assertEquals("038edcaf-2d19-4dfa-9c09-3ed09a9f4e5a", team.get(2));
        assertEquals("89a2018f-55e8-4ac3-930e-006867a9c3ca", team.get(3));
        assertEquals("1721cf87-f07c-496a-8c29-2eb8a3cc15b0", team.get(4));
        assertEquals("0", team.get(5));
    }

    @Test (priority = 2)
    public void GetTeamByIdTest() throws JSONException {
        ArrayList<String> testTeam = new Team().GetTeamById();

        assertEquals("test", testTeam.get(0));
        assertEquals("c6535841-1989-4287-8c5e-51c30830c562", testTeam.get(1));
        assertEquals("038edcaf-2d19-4dfa-9c09-3ed09a9f4e5a", testTeam.get(2));
        assertEquals("89a2018f-55e8-4ac3-930e-006867a9c3ca", testTeam.get(3));
        assertEquals("1721cf87-f07c-496a-8c29-2eb8a3cc15b0", testTeam.get(4));
    }

    @Test (priority = 3)
    public void GetTeamsTest() {
        assertEquals("test", new Team().GetTeams());
    }

    @Test (priority = 4)
    public void EditTeamTest() throws JSONException {
        assertEquals("NewTeam", new Team().EditTeam());
    }
}

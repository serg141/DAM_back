package DAM.Tests.Teams;

import DAM.Helper.Teams.GetTeamById;
import org.json.JSONException;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GetTeamIdTest {

    @Test
    public void getTeamId() throws JSONException {
        ArrayList<String> testTeam = new GetTeamById().getTeamData();

        assertEquals("test", testTeam.get(0));
        assertEquals("c6535841-1989-4287-8c5e-51c30830c562", testTeam.get(1));
        assertEquals("038edcaf-2d19-4dfa-9c09-3ed09a9f4e5a", testTeam.get(2));
        assertEquals("89a2018f-55e8-4ac3-930e-006867a9c3ca", testTeam.get(3));
        assertEquals("1721cf87-f07c-496a-8c29-2eb8a3cc15b0", testTeam.get(4));
    }
}

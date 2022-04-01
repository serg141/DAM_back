package DAM.Tests.Teams;

import DAM.Helper.Teams.GetTeamsList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetTeamsListTest {

    @Test
    public void getTeamsList() {
        assertEquals("test", new GetTeamsList().getTeamName());
    }
}

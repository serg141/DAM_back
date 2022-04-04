package DAM.Tests.Teams;

import DAM.Helper.Teams.GetUsers;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GetUsersTest {

    @Test
    public void getUsers() {
        ArrayList<String> user = new GetUsers().getTestUser();
        assertEquals("REDACTOR", user.get(0));
        assertEquals("vtb4040204@corp.dev.vtb", user.get(1));
    }
}

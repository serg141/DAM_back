package DAM.Tests.Teams;

import DAM.Helper.Teams.GetUsers;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetUsersTest {

    @Test
    public void getUsers() {
        String[] user = new GetUsers().getTestUser();
        assertEquals("REDACTOR", user[0]);
        assertEquals("vtb4040204@corp.dev.vtb", user[1]);
    }
}

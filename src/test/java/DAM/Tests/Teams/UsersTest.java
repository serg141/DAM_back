package DAM.Tests.Teams;

import DAM.Helper.Teams.Users;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class UsersTest {
    @Test(priority = 1)
    public void AddUserToTeamTest() throws JSONException {
        ArrayList<String> team = new Users().AddUserInTeam();

        assertEquals("user2", team.get(0));
        assertEquals("test user two", team.get(1));
        assertEquals("UNASSIGNED", team.get(2));
        assertEquals("test", team.get(3));
    }

    @Test(priority = 2)
    public void SetUserRoleTest() throws JSONException {
        ArrayList<String> role = new Users().SetUserRole();

        assertEquals("user-creator", role.get(0));
        assertEquals("test user creator", role.get(1));
        assertEquals("CONTENT_MANAGER", role.get(2));
        assertEquals("MODERATOR", role.get(3));
        assertEquals("REDACTOR", role.get(4));
    }

    @Test(priority = 3)
    public void GetUserTest() {
        ArrayList<String> user = new Users().GetUsers();

        assertEquals("REDACTOR", user.get(0));
        assertEquals("vtb4040204@corp.dev.vtb", user.get(1));
    }
}

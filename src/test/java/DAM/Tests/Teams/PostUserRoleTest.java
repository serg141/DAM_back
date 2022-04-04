package DAM.Tests.Teams;

import DAM.Helper.Teams.SetUserRole;
import org.json.JSONException;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PostUserRoleTest {

    @Test
    public void postUserRoleContentManager() throws JSONException {
        ArrayList<String> role = new SetUserRole().getRole();

        assertEquals("user2", role.get(0));
        assertEquals("test user two", role.get(1));
        assertEquals("CONTENT_MANAGER", role.get(2));
        assertEquals("MODERATOR", role.get(3));
        assertEquals("REDACTOR", role.get(4));
    }
}

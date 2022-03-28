package DAM.Tests.Teams;

import DAM.Helper.Teams.SetUserRole;
import org.json.JSONException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PostUserRoleTest {

    @Test
    public void postUserRoleContentManager() throws JSONException {
        String[] role = new SetUserRole().getRole();

        assertEquals("user2", role[0]);
        assertEquals("test user two", role[1]);
        assertEquals("CONTENT_MANAGER", role[2]);
        assertEquals("MODERATOR", role[3]);
        assertEquals("REDACTOR", role[4]);
    }
}

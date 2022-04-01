package DAM.Tests.Teams;

import DAM.Helper.Teams.GetUserList;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class GetUsersListTest {

    @Test
    public void getUserList() {
        ArrayList<String> userName = new GetUserList().getFullName();
        boolean b = userName.contains("Камынин Сергей Игоревич");
        assertTrue(b);
    }
}

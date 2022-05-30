package DAM.Helper.IB;

import lombok.Data;

import java.sql.SQLException;

@Data
public class CheckRole {
    public void CheckRoleModerator() throws SQLException {
        String role = new SetRole().GetRole();
        if (!role.equals("MODERATOR")) {
            new SetRole().SetRoleModerator();
        }
    }

    public void CheckRoleContentManager() throws SQLException {
        String role = new SetRole().GetRole();
        if (!role.equals("CONTENT_MANAGER")) {
            new SetRole().SetRoleContentManager();
        }
    }
}

package DAM.Parametrs.Teams;

import lombok.Data;
import org.json.JSONException;
import org.json.JSONObject;

@Data
public class UserRole {
    final JSONObject userRoleContentManager = new JSONObject();
    final JSONObject userRoleRedactor = new JSONObject();
    final JSONObject userRoleModerator = new JSONObject();

    public UserRole() throws JSONException {
        userRoleContentManager.put("data", "CONTENT_MANAGER");
        userRoleModerator.put("data", "MODERATOR");
        userRoleRedactor.put("data", "REDACTOR");
    }
}

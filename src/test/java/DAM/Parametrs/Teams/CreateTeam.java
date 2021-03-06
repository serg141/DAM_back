package DAM.Parametrs.Teams;

import lombok.Data;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Data
public class CreateTeam {
    final JSONObject team = new JSONObject();

    public CreateTeam() throws JSONException {
        JSONObject placement = new JSONObject();
        placement.put("channelId", "c6535841-1989-4287-8c5e-51c30830c562");
        placement.put("locationId", "038edcaf-2d19-4dfa-9c09-3ed09a9f4e5a");
        placement.put("positionId", "89a2018f-55e8-4ac3-930e-006867a9c3ca");
        placement.put("formatId", "1721cf87-f07c-496a-8c29-2eb8a3cc15b0");

        JSONArray userLogins = new JSONArray();

        JSONArray placements = new JSONArray();
        placements.put(placement);

        team.put("name", "test");
        team.put("userLogins", userLogins);
        team.put("placements", placements);
    }
}

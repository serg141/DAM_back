package DAM.Tests.Filters;

import DAM.Filters.FilterByCreatorIds;
import org.json.JSONException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class PostCampaignsAllCreatorIdsTest {
    List<String> user;

    @Test
    public void postCampaignsAll() throws JSONException {
        user = new FilterByCreatorIds().getCreatedBy();
        for (String s : user) {
            assertTrue(s.contains("Камынин Сергей Игоревич"));
        }
    }
}

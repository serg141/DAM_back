package DAM.Tests.Filters;

import DAM.Parametrs.Filters.FiltersParams;
import DAM.PojoClasses.Content;
import DAM.Specification;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class PostCampaignsAllFiltersTest {
    String body;

    @Before
    public void getEndpoint() throws JSONException {
        body = new FiltersParams().getFilter();
    }

    @Test
    public void postCampaignsAll() {
        Specification.installSpec(Specification.requestFilter(), Specification.responseSpec200());
        List<Content> data = given()
                .body(body)
                .when().post().then()
                .extract().body().jsonPath().getList("content", Content.class);

        List<String> status = data.stream().map(Content::getStatus).collect(Collectors.toList());
        List<String> name = data.stream().map(Content::getName).collect(Collectors.toList());
        for (String s : name) {
            assertTrue(s.contains("Campaign"));
            assertTrue(!status.contains("DRAFT") & !status.contains("REMOVED"));
        }
    }
}

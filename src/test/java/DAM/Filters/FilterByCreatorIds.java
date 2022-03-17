package DAM.Filters;

import DAM.Parametrs.Filters.CreatorParams;
import DAM.PojoClasses.AllCampaignsByCreatorId;
import DAM.Specification;
import org.json.JSONException;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class FilterByCreatorIds {
    List<String> createdBy;
    String testBody;

    public FilterByCreatorIds() throws JSONException {
        testBody = new CreatorParams().getBody();

        Specification.installSpec(Specification.requestFilter(), Specification.responseSpec200());

        List<AllCampaignsByCreatorId> content = given()
                .body(testBody)
                .when()
                .post()
                .then()
                .extract().body().jsonPath().getList("content", AllCampaignsByCreatorId.class);

        createdBy = content.stream().map(AllCampaignsByCreatorId::getCreatedBy).
                collect(Collectors.toList());
    }

    public List<String> getCreatedBy() {
        return createdBy;
    }
}

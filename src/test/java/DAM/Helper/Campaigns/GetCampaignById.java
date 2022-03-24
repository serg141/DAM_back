package DAM.Helper.Campaigns;

import DAM.Parametrs.Filters.FilterByName;
import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

@Data
public class GetCampaignById {
    String[] campaign;

    public GetCampaignById() throws JSONException {
        campaign = new String[3];

        String body = new FilterByName().getBody();

        Specification.installSpec(Specification.requestSpecLogIn(), Specification.responseSpec200());

        Response response = given()
                .body(body)
                .when()
                .post("all")
                .then().extract().response();

        String id = response.path("content[0].id");

        response = given()
                .when()
                .get(id)
                .then().extract().response();

        campaign[0] = response.path("name");
        campaign[1] = response.path("type");
        campaign[2] = response.path("id");
    }
}

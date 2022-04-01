package DAM.Helper.Campaigns;

import DAM.Parametrs.Filters.FilterByName;
import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class GetCampaignById {
    private ArrayList<String> getCamp = new ArrayList<>();

    public GetCampaignById() throws JSONException {
        String body = new FilterByName().getBody();

        Specification.installSpec(Specification.requestSpecLogIn(), Specification.responseSpec200());

        Response response = given().body(body).when().post("all").then().extract().response();
        String id = response.path("content[0].id");
        response = given().when().get(id).then().extract().response();

        getCamp.add(response.path("name"));
        getCamp.add(response.path("type"));
        getCamp.add(response.path("id"));
    }
}

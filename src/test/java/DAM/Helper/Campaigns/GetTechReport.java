package DAM.Helper.Campaigns;

import DAM.Parametrs.Filters.FilterByName;
import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
@Data
public class GetTechReport {
    private ArrayList<String> report1 = new ArrayList<>();

    public GetTechReport() throws JSONException {
        String body = new FilterByName().getBody().toString();
        Specification.installSpec(Specification.requestSpecCampaigns(), Specification.responseSpec200());

        Response response = given().body(body).when().post("all").then().extract().response();
        String id = response.path("content[0].id");
        response = given().when().get(id + "/tech-report").then().extract().response();

        report1.add(response.path("items[0].chartType"));
        report1.add(response.path("items[0].title"));
    }
}

package DAM.Helper.Campaigns;

import DAM.Parametrs.Filters.FilterByName;
import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import static io.restassured.RestAssured.given;
@Data
public class GetTechReport {
    String[] report;

    public GetTechReport() throws JSONException {
        report = new String[2];

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
                .get(id + "/tech-report")
                .then().extract().response();

        report[0] = response.path("items[0].chartType");
        report[1] = response.path("items[0].title");
    }
}

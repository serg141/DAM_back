package DAM.Helper.SegmentCategories;

import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class SegmentCategories {
    ArrayList<String> categories = new ArrayList<>();

    public SegmentCategories() {
        Specification.installSpec(Specification.requestSegmentCategories(), Specification.responseSpec200());

        Response response = given().when().get().then().extract().response();

        categories.add(response.path("AUDITORIAL[0].code"));
        categories.add(response.path("CLIENTTYPE[0].code"));
        categories.add(response.path("BLACKLIST[0].code"));
        categories.add(response.path("AGE[0].code"));
        categories.add(response.path("GENDER[0].code"));
    }
}

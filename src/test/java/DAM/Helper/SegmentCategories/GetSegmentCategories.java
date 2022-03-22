package DAM.Helper.SegmentCategories;

import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;

import static io.restassured.RestAssured.given;

@Data
public class GetSegmentCategories {
    String[] categories;

    public GetSegmentCategories() {
        categories = new String[5];
        Specification.installSpec(Specification.requestSegmentCategories(), Specification.responseSpec200());

        Response response = given().when().get().then().extract().response();

        categories[0] = response.path("AUDITORIAL[0].code").toString();
        categories[1] = response.path("CLIENTTYPE[0].code").toString();
        categories[2] = response.path("BLACKLIST[0].code").toString();
        categories[3] = response.path("AGE[0].code").toString();
        categories[4] = response.path("GENDER[0].code").toString();
    }
}

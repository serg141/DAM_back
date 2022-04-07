package ClientInfo.Helper;

import ClientInfo.Specification;
import io.restassured.response.Response;
import lombok.Data;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class StLstCrmFlgTrue {
    private ArrayList<String> segments = new ArrayList<>();

    public StLstCrmFlgTrue() {
        Specification.installSpec(Specification.requestSpec(), Specification.responseSpec200());

        Response response = given().when().get("1234567896").then().extract().response();
        segments.add(response.path("id"));
        segments.add(response.path("segmentsList.SPECIAL[0]"));
        segments.add(response.path("segmentsList.SPECIAL[1]"));
    }
}

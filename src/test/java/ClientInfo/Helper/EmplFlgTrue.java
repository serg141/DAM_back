package ClientInfo.Helper;

import ClientInfo.Specification;
import io.restassured.response.Response;
import lombok.Data;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class EmplFlgTrue {
    private ArrayList<String> segments = new ArrayList<>();

    public EmplFlgTrue() {
        Specification.installSpec(Specification.requestSpec(), Specification.responseSpec200());

        Response response = given().when().get("1234567895").then().extract().response();
        segments.add(response.path("id"));
        segments.add(response.path("segmentsList.CLIENT_TYPE[0]"));
    }
}

package Integration;

import Content.Specification;
import io.restassured.response.Response;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

@Data
public class ActivatorOnlyAndroid {
    String flightId;

    public ActivatorOnlyAndroid() {
        Specification.installSpec(Specification.activator(), Specification.responseSpec200());

        Response response = given().when().get("/test/flights").then().extract().response();

        List<ArrayList<String>> include = response.path("segments.include");
        List<ArrayList<String>> id = response.path("id");

        for (int i = 0; i < include.size(); i++) {
            if (include.get(i).contains("MOBILE_PLATFORM:ANDROID") && include.get(i).size() == 1) {
                flightId = String.valueOf(id.get(i));
            }
        }
    }
}

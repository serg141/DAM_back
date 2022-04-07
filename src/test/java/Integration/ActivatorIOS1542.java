package Integration;

import Content.Specification;
import io.restassured.response.Response;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

@Data
public class ActivatorIOS1542 {
    String flightId;

    public ActivatorIOS1542() {
        Specification.installSpec(Specification.activator(), Specification.responseSpec200());

        Response response = given().when().get("/test/flights").then().extract().response();

        List<ArrayList<String>> include = response.path("segments.include");
        List<ArrayList<String>> id = response.path("id");

        for (int i = 0; i < include.size(); i++) {
            if (include.get(i).contains("MOBILE_PLATFORM:IOS") && include.get(i).size() == 3 &&
                    include.get(i).contains("MOBILE:IOS_15.4.2")) {
                flightId = String.valueOf(id.get(i));
            }
        }
    }
}

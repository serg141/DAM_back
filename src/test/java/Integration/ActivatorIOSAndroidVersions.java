package Integration;

import Content.Specification;
import io.restassured.response.Response;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

@Data
public class ActivatorIOSAndroidVersions {
    String flightId;

    public ActivatorIOSAndroidVersions() {
        Specification.installSpec(Specification.activator(), Specification.responseSpec200());

        Response response = given().when().get("/test/flights").then().extract().response();

        List<ArrayList<String>> include = response.path("segments.exclude");
        List<ArrayList<String>> id = response.path("id");

        for (int i = 0; i < include.size(); i++) {
            if (include.get(i).contains("MOBILE:IOS_15.4.1") && include.get(i).contains("MOBILE:ANDROID_15.4.1")) {
                flightId = String.valueOf(id.get(i));
            }
        }
    }
}

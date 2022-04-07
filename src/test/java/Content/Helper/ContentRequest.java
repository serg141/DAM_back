package Content.Helper;

import Content.Specification;
import io.restassured.response.Response;
import lombok.Data;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class ContentRequest {
    String content;

    public ContentRequest(String body) {
        Specification.installSpec(Specification.requestSpec(), Specification.responseSpec200());

        Response response = given().header("x-mdm-id", "1234567890").body(body).when().post().
                then().extract().response();

        content = response.path("locations[0].positions[0].contents[0].flightId");
    }

    public ArrayList<String> ContentMoneyBox(String body) {
        Response response = given().header("x-mdm-id", "1234567897").body(body).when().post().
                then().extract().response();

        ArrayList<String> ids = new ArrayList<>();

        ids.add(response.path("locations[0].positions[0].contents[0].flightId"));
        ArrayList<String> value = (response.path("locations[0].positions[0].contents[0].contentPages[0]." +
                "elements.elementValue"));
        ArrayList<String> elementId = (response.path("locations[0].positions[0].contents[0].contentPages[0]." +
                "elements.elementId"));

        for(int i = 0; i < elementId.size(); i++) {
            if (elementId.get(i) != null) {
                if(elementId.get(i).equals("preroll-heading")) {
                    ids.add(value.get(i));
                }
                else if(elementId.get(i).contains("preroll-description")) {
                    ids.add(value.get(i));
                }
            }
        }

        return ids;
    }

    public String IOSVersions(String body) {
        Specification.installSpec(Specification.requestSpec(), Specification.responseSpec200());
        String versions;

        Response response = given().header("x-mdm-id", "1234567890").body(body).when().post().
                then().extract().response();
        versions = response.path("locations[0].positions[0].contents[0].flightId");

        return versions;
    }

    public String AndroidVersions(String body) {
        Specification.installSpec(Specification.requestSpec(), Specification.responseSpec200());
        String versions;

        Response response = given().header("x-mdm-id", "1234567890").body(body).when().post().
                then().extract().response();
        versions = response.path("locations[0].positions[0].contents[0].flightId");

        return versions;
    }
}

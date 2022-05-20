package Example;

import Content.Specification;
import io.restassured.response.Response;
import lombok.Data;

import static io.restassured.RestAssured.given;

@Data
public class Test1 {
    String content;

    public Test1(String body) {
        Specification.installSpec(Specification.requestSpec(), Specification.responseSpec200());

        Response response = given().header("x-mdm-id", "1234567890").body(body).when().post().
                then().extract().response();

        content = response.path("locations[0].positions[0].contents[0].flightId");
    }
}

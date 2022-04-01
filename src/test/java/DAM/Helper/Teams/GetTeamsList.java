package DAM.Helper.Teams;

import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;

import static io.restassured.RestAssured.given;

@Data
public class GetTeamsList {
    String teamName;

    public GetTeamsList() {
        Specification.installSpec(Specification.Teams(), Specification.responseSpec200());
        Response response = given().when().get().then().extract().response();

        teamName = response.path("content[0].name");
    }
}

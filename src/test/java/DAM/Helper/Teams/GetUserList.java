package DAM.Helper.Teams;

import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class GetUserList {
    ArrayList<String> fullName;

    public GetUserList() {
        Specification.installSpec(Specification.Users(), Specification.responseSpec200());
        Response response = given().when().get("/list").then().extract().response();
        fullName = response.path("fullName");
    }
}

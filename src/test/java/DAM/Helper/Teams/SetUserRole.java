package DAM.Helper.Teams;

import DAM.Parametrs.Teams.UserRole;
import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class SetUserRole {
    ArrayList<String> role = new ArrayList<>();

    public SetUserRole() throws JSONException {
        Specification.installSpec(Specification.Users(), Specification.responseSpec200());

        String body = new UserRole().getUserRoleContentManager();
        Response response = given().when().body(body).post("/user2/role").then().extract().response();
        role.add(response.path("login"));
        role.add(response.path("fullName"));
        role.add(response.path("role"));

        body = new UserRole().getUserRoleModerator();
        response = given().when().body(body).post("/user2/role").then().extract().response();
        role.add(response.path("role"));

        body = new UserRole().getUserRoleRedactor();
        response = given().when().body(body).post("/user2/role").then().extract().response();
        role.add(response.path("role"));
    }
}

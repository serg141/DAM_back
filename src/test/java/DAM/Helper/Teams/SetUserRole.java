package DAM.Helper.Teams;

import DAM.Parametrs.Teams.UserRole;
import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

@Data
public class SetUserRole {
    String[] role;

    public SetUserRole() throws JSONException {
        role = new String[5];
        Specification.installSpec(Specification.Users(), Specification.responseSpec200());

        String body = new UserRole().getUserRoleContentManager();
        Response response = given().when().body(body).post("/user2/role").then().extract().response();
        role[0] = response.path("login");
        role[1] = response.path("fullName");
        role[2] = response.path("role");

        body = new UserRole().getUserRoleModerator();
        response = given().when().body(body).post("/user2/role").then().extract().response();
        role[3] = response.path("role");

        body = new UserRole().getUserRoleRedactor();
        response = given().when().body(body).post("/user2/role").then().extract().response();
        role[4] = response.path("role");
    }
}

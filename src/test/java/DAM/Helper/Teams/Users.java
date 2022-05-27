package DAM.Helper.Teams;

import DAM.Parametrs.Teams.UserRole;
import DAM.Specification;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class Users {

    public Users() {
        Specification.installSpec(Specification.Users(), Specification.responseSpec200());
    }

    public ArrayList<String> AddUserInTeam() throws JSONException {
        ArrayList<String> team = new ArrayList<>();
        String id = new Team().GetTeamById().get(5);

        JSONArray teamId = new JSONArray();
        teamId.put(id);
        JSONObject body = new JSONObject();
        body.put("data", teamId);

        Response response = given().spec(Specification.Users()).when().body(body.toString()).post("/user2/teams")
                .then().extract().response();

        team.add(response.path("login"));
        team.add(response.path("fullName"));
        team.add(response.path("role"));
        team.add(response.path("teams[0].name"));

        return team;
    }

    public ArrayList<String> SetUserRole() throws JSONException {
        ArrayList<String> role = new ArrayList<>();

        String body = new UserRole().getUserRoleContentManager().toString();
        Response response = given().when().body(body).post("/user-creator/role").then().extract().response();
        role.add(response.path("login"));
        role.add(response.path("fullName"));
        role.add(response.path("role"));

        body = new UserRole().getUserRoleModerator().toString();
        response = given().when().body(body).post("/user-creator/role").then().extract().response();
        role.add(response.path("role"));

        body = new UserRole().getUserRoleRedactor().toString();
        response = given().when().body(body).post("/user-creator/role").then().extract().response();
        role.add(response.path("role"));

        return role;
    }

    public ArrayList<String> GetUsers() {
        ArrayList<String> testUser = new ArrayList<>();

        List<DAM.PojoClasses.Users> user = given().when().get().then().extract().body()
                .jsonPath().getList("content", DAM.PojoClasses.Users.class);

        List<String> login = user.stream().map(DAM.PojoClasses.Users::getLogin).collect(Collectors.toList());
        List<String> fullName = user.stream().map(DAM.PojoClasses.Users::getFullName).collect(Collectors.toList());
        List<String> role = user.stream().map(DAM.PojoClasses.Users::getRole).collect(Collectors.toList());

        for(int i = 0; i < login.size(); i++) {
            if(fullName.get(i).contains("Камынин Сергей Игоревич")) {
                testUser.add(role.get(i));
                testUser.add(login.get(i));
            }
        }

        return testUser;
    }
}

package DAM.Tests.Teams;

import DAM.EndPoints;
import DAM.Filters.Users;
import DAM.LogIn;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class GetUsersTest {
    String logIn, users;

    @Before
    public void getEndpoint() throws JSONException {
        logIn = new LogIn().logIn();

        users = new EndPoints().getUsers();
    }

    @Test
    public void getUsers() {
        List<Users> user = given()
                .cookie("JSESSIONID", logIn)
                .when()
                .get(users)
                .then().log().all()
                .extract().body().jsonPath().getList("content", Users.class);

        List<String> login = user.stream().map(Users::getLogin).collect(Collectors.toList());
        List<String> fullName = user.stream().map(Users::getFullName).collect(Collectors.toList());
        List<String> role = user.stream().map(Users::getRole).collect(Collectors.toList());

        for (int i = 0; i < login.size(); i++) {
            assertTrue(fullName.get(i).contains("Камынин Сергей Игоревич"));
            assertTrue(role.get(i).contains("REDACTOR"));
            assertTrue(login.get(i).contains("vtb4040204@corp.dev.vtb"));
            break;
        }
    }
}

package DAM.Helper.Teams;

import DAM.PojoClasses.Users;
import DAM.Specification;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

@Data
public class GetUsers {
    ArrayList<String> testUser = new ArrayList<>();

    public GetUsers() {
        Specification.installSpec(Specification.Users(), Specification.responseSpec200());
        List<Users> user = given().when().get().then().extract().body().jsonPath().getList("content", Users.class);

        List<String> login = user.stream().map(Users::getLogin).collect(Collectors.toList());
        List<String> fullName = user.stream().map(Users::getFullName).collect(Collectors.toList());
        List<String> role = user.stream().map(Users::getRole).collect(Collectors.toList());

        for(int i = 0; i < login.size(); i++) {
            if(fullName.get(i).contains("Камынин Сергей Игоревич")) {
                testUser.add(role.get(i));
                testUser.add(login.get(i));
            }
        }
    }
}

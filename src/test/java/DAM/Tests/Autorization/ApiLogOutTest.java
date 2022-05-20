package DAM.Tests.Autorization;

import DAM.Specification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiLogOutTest {
    @Test
    public void postLogOutTest() {
        Specification.installSpec(Specification.requestSpecLogIn(), Specification.responseSpec200());
        given().when().post("/logout");
    }
}

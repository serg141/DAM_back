package DAM.Tests.Support;

import DAM.Specification;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostReactivateTest {

    @Test
    public void postReactivateTest() {
        Specification.installSpec(Specification.Reactivate(), Specification.responseSpec200());

        given().when().post();
        given().when().get();
    }
}

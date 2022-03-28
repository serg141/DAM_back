package DAM.Tests.Placements.Lists;

import DAM.Specification;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetListTest {

    @Test
    public void getListTest() {
        Specification.installSpec(Specification.List(), Specification.responseSpec200());
        given().when().get();
    }
}

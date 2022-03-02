package DAM.Tests.Placements;

import DAM.EndPoints;
import DAM.LogIn;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetListTest {
    String lists;

    @Test
    public void getListTest() {
        String logIn = new LogIn().logIn();
        String lists = new EndPoints().getLists();

        given()
                .cookie("JSESSIONID", logIn)
                .when()
                .get(lists)
                .then().statusCode(200);
    }
}

package DAM.Tests.Placements.Lists;

import DAM.EndPoints;
import DAM.LogIn;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetListTest {
    String logIn, lists;

    @Before
    public void getData() {
        logIn = new LogIn().logIn();
        lists = new EndPoints().getLists();
    }

    @Test
    public void getListTest() {
       given()
                .cookie("JSESSIONID", logIn)
                .when()
                .get(lists);
    }
}

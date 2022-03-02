package DAM.Tests.Placements;

import DAM.EndPoints;
import DAM.Lists.CreateLinkList;
import DAM.LogIn;
import org.json.JSONException;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreateLinkListTest {
    String list;

    @Test
    public void createLinkListTest() throws JSONException {
        String logIn = new LogIn().logIn();
        String lists = new EndPoints().getLists();
        String body = new CreateLinkList().getLinkList();

        given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .when()
                .post(lists)
                .then().statusCode(200);
    }
}

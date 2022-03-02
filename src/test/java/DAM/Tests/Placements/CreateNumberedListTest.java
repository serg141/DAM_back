package DAM.Tests.Placements;

import DAM.EndPoints;
import DAM.Lists.CreateNumberList;
import DAM.LogIn;
import org.json.JSONException;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreateNumberedListTest {
    String list;

    @Test
    public void createNumberedListTest() throws JSONException {
        String logIn = new LogIn().logIn();
        String lists = new EndPoints().getLists();
        String body = new CreateNumberList().getNumberedList();

        given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .when()
                .post(lists)
                .then().statusCode(200);
    }
}

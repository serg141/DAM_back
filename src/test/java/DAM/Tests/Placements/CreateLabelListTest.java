package DAM.Tests.Placements;

import DAM.EndPoints;
import DAM.Lists.CreateLabelList;
import DAM.LogIn;
import org.json.JSONException;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreateLabelListTest {
    String list;

    @Test
    public void createNumberedListTest() throws JSONException {
        String logIn = new LogIn().logIn();
        String lists = new EndPoints().getLists();
        String body = new CreateLabelList().getLabelList();

        given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .when()
                .post(lists)
                .then().statusCode(200);
    }
}

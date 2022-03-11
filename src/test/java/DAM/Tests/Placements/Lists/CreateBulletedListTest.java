package DAM.Tests.Placements.Lists;

import DAM.EndPoints;
import DAM.LogIn;
import DAM.Parametrs.Placements.Lists.CreateBulletedList;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class CreateBulletedListTest {
    String lists, logIn, body;

    @Before
    public void getEndpoint() throws JSONException {
        lists = new EndPoints().getLists();
        logIn = new LogIn().logIn();
        body = new CreateBulletedList().getBulletedList();
    }

    @Test
    public void createBulletedListTest() {
        Response response = given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .when()
                .post(lists)
                .then()
                .extract().response();

        LinkedHashMap<String,Object> list = response.path("elements[0]");

        assertEquals("BulletedList", response.path("name"));
        assertEquals("BULLETED_LIST", response.path("code"));
        assertEquals("Заголовок списка", list.get("name"));
        assertEquals("description", list.get("elementId"));
        assertEquals("TEXT", list.get("type"));
        assertEquals("LIST_ROW_TITLE", list.get("elementStyle"));
        assertEquals(true, list.get("required"));
        assertEquals(1, list.get("elementOrder"));

        String id = response.path("id");

        given()
                .cookie("JSESSIONID", logIn)
                .when()
                .delete(lists + id)
                .then().statusCode(200);
    }
}

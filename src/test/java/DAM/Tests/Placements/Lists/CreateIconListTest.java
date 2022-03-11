package DAM.Tests.Placements.Lists;

import DAM.EndPoints;
import DAM.LogIn;
import DAM.Parametrs.Placements.Lists.CreateIconList;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class CreateIconListTest {
    String lists;
    String logIn;
    String body;

    @Before
    public void getEndpoint() throws JSONException {
        lists = new EndPoints().getLists();
        logIn = new LogIn().logIn();
        body = new CreateIconList().getIconList();
    }

    @Test
    public void createIconListTest() {
        Response response = given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .when()
                .post(lists)
                .then()
                .extract().response();

        LinkedHashMap<String,Object> list1 = response.path("elements[0]");
        LinkedHashMap<String,Object> list2 = response.path("elements[1]");

        assertEquals("IconList", response.path("name"));
        assertEquals("ICON_LIST", response.path("code"));

        assertEquals("Иконка", list1.get("name"));
        assertEquals("image", list1.get("elementId"));
        assertEquals("IMAGE", list1.get("type"));
        assertEquals(true, list1.get("required"));

        assertEquals("Заголовок", list2.get("name"));
        assertEquals("title", list2.get("elementId"));
        assertEquals("TEXT", list2.get("type"));
        assertEquals("LIST_ROW_TITLE", list2.get("elementStyle"));
        assertEquals(true, list2.get("required"));

        String id = response.path("id");

        given()
                .cookie("JSESSIONID", logIn)
                .when()
                .delete(lists + id)
                .then().statusCode(200);
    }
}

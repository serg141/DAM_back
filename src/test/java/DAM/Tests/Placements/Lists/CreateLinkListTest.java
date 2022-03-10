package DAM.Tests.Placements.Lists;

import DAM.EndPoints;
import DAM.LogIn;
import DAM.Parametrs.Lists.CreateLinkList;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class CreateLinkListTest {
    String lists;
    String logIn;
    String body;

    @Before
    public void getEndpoint() throws JSONException {
        lists = new EndPoints().getLists();
        logIn = new LogIn().logIn();
        body = new CreateLinkList().getLinkList();
    }

    @Test
    public void createLinkListTest() {
        Response response = given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .when()
                .post(lists)
                .then()
                .extract().response();

        LinkedHashMap<String,Object> list1 = response.path("elements[0]");
        LinkedHashMap<String,Object> list2 = response.path("elements[1]");

        assertEquals("LinkList", response.path("name"));
        assertEquals("LINK_LIST", response.path("code"));

        assertEquals("Фон ссылки", list1.get("name"));
        assertEquals("body", list1.get("elementId"));
        assertEquals("BLOCK", list1.get("type"));
        assertEquals("STYLE_IMAGE", list1.get("backgroundType"));
        assertEquals(true, list1.get("required"));

        assertEquals("Ссылка", list2.get("name"));
        assertEquals("description", list2.get("elementId"));
        assertEquals("TEXT", list2.get("type"));
        assertEquals(true, list2.get("required"));

        String id = response.path("id");

        given()
                .cookie("JSESSIONID", logIn)
                .when()
                .delete(lists + id)
                .then().statusCode(200);
    }
}

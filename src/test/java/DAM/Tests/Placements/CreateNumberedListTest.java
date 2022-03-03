package DAM.Tests.Placements;

import DAM.EndPoints;
import DAM.LogIn;
import DAM.Parametrs.Lists.CreateNumberList;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import java.util.LinkedHashMap;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class CreateNumberedListTest {
    String lists;
    String logIn;
    String body;

    @Before
    public void getEndpoint() throws JSONException {
        lists = new EndPoints().getLists();
        logIn = new LogIn().logIn();
        body = new CreateNumberList().getNumberedList();
    }

    @Test
    public void createNumberedListTest() {
        Response response = given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .when()
                .post(lists)
                .then().statusCode(200).contentType(ContentType.JSON)
                .extract().response();

        LinkedHashMap<String,Object> list1 = response.path("elements[0]");
        LinkedHashMap<String,Object> list2 = response.path("elements[1]");

        assertEquals("NumberedList", response.path("name"));
        assertEquals("NUMBERED_LIST", response.path("code"));

        assertEquals(80, list1.get("maxLength"));
        assertEquals("Заголовок", list1.get("name"));
        assertEquals("title", list1.get("elementId"));
        assertEquals("TEXT", list1.get("type"));
        assertEquals("LIST_ROW_TITLE", list1.get("elementStyle"));
        assertEquals(true, list1.get("required"));

        assertEquals(150, list2.get("maxLength"));
        assertEquals("Описание", list2.get("name"));
        assertEquals("description2", list2.get("elementId"));
        assertEquals("TEXT", list2.get("type"));
        assertEquals("LIST_ROW_TITLE", list1.get("elementStyle"));
        assertEquals(false, list2.get("required"));

        String id = response.path("id");

        given()
                .cookie("JSESSIONID", logIn)
                .when()
                .delete(lists + id)
                .then().statusCode(200);
    }
}

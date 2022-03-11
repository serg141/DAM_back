package DAM.Lists;

import DAM.EndPoints;
import DAM.LogIn;
import DAM.Parametrs.Placements.Lists.CreateBulletedList;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

public class CreateList {
    String id;

    public CreateList() throws JSONException {
        String body = new CreateBulletedList().getBulletedList();
        String lists = new EndPoints().getLists();
        String logIn = new LogIn().logIn();

        Response response = given()
                .cookie("JSESSIONID", logIn)
                .body(body)
                .when()
                .post(lists)
                .then().statusCode(200).contentType(ContentType.JSON)
                .extract().response();

        id = response.path("id");
    }

    public String getId() {
        return id;
    }
}

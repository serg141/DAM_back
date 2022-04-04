package DAM.Helper.Placements;

import DAM.Parametrs.Placements.Lists.CreateBulletedList;
import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class BulletedList {
    ArrayList<String> bulletedList = new ArrayList<>();

    public BulletedList() throws JSONException {
        Specification.installSpec(Specification.List(), Specification.responseSpec200());

        String body = new CreateBulletedList().getBulletedList();

        Response response = given().body(body).when().post().then().extract().response();
        if(response.path("elements[0].required")) {
            bulletedList.add(response.path("name"));
            bulletedList.add(response.path("code"));
            bulletedList.add(response.path("elements[0].name"));
            bulletedList.add(response.path("elements[0].elementId"));
            bulletedList.add(response.path("elements[0].type"));
            bulletedList.add(response.path("elements[0].elementStyle"));
        }

        String id = response.path("id");

        given().when().delete(id);
    }
}

package DAM.Helper.Placements;

import DAM.Parametrs.Placements.Lists.CreateBulletedList;
import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

@Data
public class BulletedList {
    String[] bulletedList;

    public BulletedList() throws JSONException {
        Specification.installSpec(Specification.List(), Specification.responseSpec200());

        String body = new CreateBulletedList().getBulletedList();
        bulletedList = new String[6];

        Response response = given().body(body).when().post().then().extract().response();
        if(response.path("elements[0].required")) {
            bulletedList[0] = response.path("name");
            bulletedList[1] = response.path("code");
            bulletedList[2] = response.path("elements[0].name");
            bulletedList[3] = response.path("elements[0].elementId");
            bulletedList[4] = response.path("elements[0].type");
            bulletedList[5] = response.path("elements[0].elementStyle");
        }

        String id = response.path("id");

        given().when().delete(id);
    }
}

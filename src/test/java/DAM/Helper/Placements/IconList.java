package DAM.Helper.Placements;

import DAM.Parametrs.Placements.Lists.CreateIconList;
import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

@Data
public class IconList {
    String[] iconList;

    public IconList() throws JSONException {
        Specification.installSpec(Specification.List(), Specification.responseSpec200());

        String body = new CreateIconList().getIconList();
        iconList = new String[9];

        Response response = given().body(body).when().post().then().extract().response();
        if(response.path("elements[0].required")) {
            if(response.path("elements[1].required")) {
                iconList[0] = response.path("name");
                iconList[1] = response.path("code");
                iconList[2] = response.path("elements[0].name");
                iconList[3] = response.path("elements[0].elementId");
                iconList[4] = response.path("elements[0].type");
                iconList[5] = response.path("elements[1].name");
                iconList[6] = response.path("elements[1].elementId");
                iconList[7] = response.path("elements[1].type");
                iconList[8] = response.path("elements[1].elementStyle");
            }
        }

        String id = response.path("id");

        given().when().delete(id);
    }
}

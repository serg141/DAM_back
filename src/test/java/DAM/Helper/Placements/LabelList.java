package DAM.Helper.Placements;

import DAM.Parametrs.Placements.Lists.CreateLabelList;
import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

@Data
public class LabelList {
    String[] labelList;

    public LabelList() throws JSONException {
        Specification.installSpec(Specification.List(), Specification.responseSpec200());

        String body = new CreateLabelList().getLabelList();
        labelList = new String[9];

        Response response = given().body(body).when().post().then().extract().response();
        if(response.path("elements[0].required")) {
            if(response.path("elements[1].required")) {
                labelList[0] = response.path("name");
                labelList[1] = response.path("code");
                labelList[2] = response.path("elements[0].backgroundType");
                labelList[3] = response.path("elements[0].name");
                labelList[4] = response.path("elements[0].elementId");
                labelList[5] = response.path("elements[0].type");
                labelList[6] = response.path("elements[1].name");
                labelList[7] = response.path("elements[1].elementId");
                labelList[8] = response.path("elements[1].type");
            }
        }

        String id = response.path("id");

        given().when().delete(id);
    }
}

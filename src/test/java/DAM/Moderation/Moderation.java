package DAM.Moderation;

import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

@Data
public class Moderation {
    String[] status;

    public Moderation() throws JSONException {
        status = new String[4];

        String[] idList = new DAM.Parametrs.Moderation.SendToModeration().getIdList();
        String body = idList[0];
        String id = idList[1];

        given().body(body).when().put("moderation");
        Response response = given().when().get(id).then().extract().response();
        status[0] = response.path("status");

        given().when().put(id + "/moderation/start");
        response = given().when().get(id).then().extract().response();
        status[1] = response.path("status");

        given().when().put(id + "/moderation/cancel");
        response = given().when().get(id).then().extract().response();
        status[2] = response.path("status");

        given().when().put(id + "/moderation/start");
        given().when().put(id + "/moderation/approve").then().statusCode(200);
    }
}

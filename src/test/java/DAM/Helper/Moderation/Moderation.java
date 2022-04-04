package DAM.Helper.Moderation;

import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class Moderation {
    ArrayList<String> status = new ArrayList<>();

    public Moderation() throws JSONException {
        ArrayList<String> idList = new DAM.Parametrs.Moderation.SendToModeration().getIdList();
        String body = idList.get(0);
        String id = idList.get(1);

        given().body(body).when().put("moderation");
        Response response = given().when().get(id).then().extract().response();
        status.add(response.path("status"));

        given().when().put(id + "/moderation/start");
        response = given().when().get(id).then().extract().response();
        status.add(response.path("status"));

        given().when().put(id + "/moderation/cancel");
        response = given().when().get(id).then().extract().response();
        status.add(response.path("status"));

        given().when().put(id + "/moderation/start");
        given().when().put(id + "/moderation/approve").then().statusCode(200);
    }
}

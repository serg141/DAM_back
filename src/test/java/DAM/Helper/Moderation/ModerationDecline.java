package DAM.Helper.Moderation;

import DAM.Parametrs.Moderation.ModerationDeclineParameters;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

@Data
public class ModerationDecline {
    String status;
    String[] comments;

    public ModerationDecline() throws JSONException {
        comments = new String[10];
        String[] idList = new DAM.Parametrs.Moderation.SendToModeration().getIdList();
        String body = idList[0];
        String body1 = new ModerationDeclineParameters().getComments();
        String id = idList[1];

        given().body(body).when().put("moderation");
        given().when().put(id + "/moderation/start");
        given().body(body1).when().put(id + "/moderation/decline");
        Response response = given().when().get(id).then().extract().response();



        status = response.path("status");
    }
}

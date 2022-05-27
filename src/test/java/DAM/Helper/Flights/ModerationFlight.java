package DAM.Helper.Flights;

import DAM.Parametrs.Moderation.ModerationDeclineParameters;
import DAM.Parametrs.Moderation.SendToModeration;
import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

@Data
public class ModerationFlight {
    public ModerationFlight() {
        Specification.installSpec(Specification.requestFlight(), Specification.responseSpec200());
    }

    public String ModerationStart() throws JSONException {
        ArrayList<String> idList = new SendToModeration().getIdList();
        String id = idList.get(1);

        Specification.installSpec(Specification.requestFlight(), Specification.responseSpec200());
        given().body(idList.get(0)).when().put("moderation");
        given().when().put(idList.get(1) + "/moderation/start");

        return id;
    }

    public List<String> GetModerationComments() throws JSONException {
        List<String> comments;
        String body = new ModerationDeclineParameters().getComments().toString();
        String id = new ModerationFlight().ModerationStart();

        given().body(body).when().put(id + "/moderation/decline");
        Response response = given().when().get(id + "/moderation/comments").then().extract().response();
        comments = response.path("comment");

        return comments;
    }

    public ArrayList<String> ModerationCancel() throws JSONException {
        ArrayList<String> status = new ArrayList<>();
        String id = new ModerationFlight().ModerationStart();

        Response response = given().when().get(id).then().extract().response();
        status.add(response.path("status"));

        given().when().put(id + "/moderation/cancel");
        response = given().when().get(id).then().extract().response();
        status.add(response.path("status"));

        return status;
    }

    public void ModerationApprove() throws JSONException {
        String id = new ModerationFlight().ModerationStart();
        given().when().put(id + "/moderation/approve").then().statusCode(200);
    }

    public String ModerationDecline() throws JSONException {
        String id = new ModerationFlight().ModerationStart();
        String body = new ModerationDeclineParameters().getComments().toString();
        given().body(body).when().put(id + "/moderation/decline");
        Response response = given().when().get(id).then().extract().response();

        return response.path("status");
    }
}

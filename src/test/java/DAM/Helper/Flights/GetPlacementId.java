package DAM.Helper.Flights;

import io.restassured.response.Response;
import org.json.JSONException;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;

public class GetPlacementId {
    String placementId, id;
    String[] ids;

    public GetPlacementId() throws JSONException {
        ids = new String[2];
        String id = new CreateFlightWithTechParameters().getFlightStepFour()[6];

        Response response = given()
                .when()
                .get(id + "/creatives")
                .then()
                .extract().response();

        LinkedHashMap<String,Object> nodes = response.path("nodes[0]");

        placementId = nodes.get("placementId").toString();

        ids[0] = id;
        ids[1] = placementId;

    }

    public String[] getIds() {
        return ids;
    }

    public String getPlacementId() {
        return placementId;
    }
}

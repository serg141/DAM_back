package DAM.Helper.Flights;

import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class GetPlacementId {
    private ArrayList<String> ids = new ArrayList<>();

    public GetPlacementId() throws JSONException {
        String id = new CreateFlightWithTechParameters().getFlightStepFour().get(6);

        Response response = given().when().get(id + "/creatives").then().extract().response();

        String placementId = response.path("nodes[0].placementId");
        ids.add(id);
        ids.add(placementId);
    }
}

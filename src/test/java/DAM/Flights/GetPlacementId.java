package DAM.Flights;

import DAM.EndPoints;
import DAM.LogIn;
import io.restassured.response.Response;
import org.json.JSONException;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;

public class GetPlacementId {
    String placementId, id;
    String[] ids;

    public GetPlacementId() throws JSONException {
        ids = new String[2];
        String logIn = new LogIn().logIn();
        String flights = new EndPoints().getFlights();
        String creative = new EndPoints().getCreative();

        id = new CreateFlightWithTechParameters().getId();

        Response response = given()
                .cookie("JSESSIONID", logIn)
                .when()
                .get(flights + id + creative)
                .then()
                .extract().response();

        LinkedHashMap<String,Object> nodes = response.path("nodes[0]");

        placementId = nodes.get("placementId").toString();

        ids[0] = id;
        ids[1] = placementId;

    }

    public String[] getId() {
        return ids;
    }

    public String getPlacementId() {
        return placementId;
    }
}

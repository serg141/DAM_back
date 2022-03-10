package DAM.Flights;

import DAM.EndPoints;
import DAM.LogIn;
import io.restassured.response.Response;
import org.json.JSONException;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;

public class GetPlacementId {
    String placementId, id;

    public GetPlacementId() throws JSONException {
        String logIn = new LogIn().logIn();
        String flights = new EndPoints().getFlights();
        String creative = new EndPoints().getCreative();

        id = new CreateFlightWithTechParameters().getId();

        Response response = given()
                .cookie("JSESSIONID", logIn)
                .when()
                .get(flights + id + creative)
                .then().statusCode(200)
                .extract().response();

        LinkedHashMap<String,Object> nodes = response.path("nodes[0]");

        placementId = nodes.get("placementId").toString();
    }

    public String getId() {
        return id;
    }

    public String getPlacementId() {
        return placementId;
    }
}

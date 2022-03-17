package DAM.Flights;

import DAM.Parametrs.Flights.CreateFlightStepFiveGhost;
import DAM.Specification;
import io.restassured.response.Response;
import org.json.JSONException;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;

public class CreateFlightStepFiveGhostWithOutPolling {
    String flightStepFiveGhostWithOutPolling;

    public CreateFlightStepFiveGhostWithOutPolling() throws JSONException {
        String[] ids = new GetPlacementId().getIds();
        String body = new CreateFlightStepFiveGhost().getFlightHideableTypeWithOutPolling();
        Specification.installSpec(Specification.requestFlight(), Specification.responseSpec200());

        Response response = given()
                .body(body)
                .queryParam("placementId", ids[1])
                .when()
                .post(ids[0] + "/creatives")
                .then()
                .extract().response();

        LinkedHashMap<String,Object> pages = response.path("pages[0]");

        if((Boolean) pages.get("showCross")) {
            flightStepFiveGhostWithOutPolling = pages.get("hideableType").toString();
        }
    }

    public String getFlightStepFiveGhostWithOutPolling() {
        return flightStepFiveGhostWithOutPolling;
    }
}

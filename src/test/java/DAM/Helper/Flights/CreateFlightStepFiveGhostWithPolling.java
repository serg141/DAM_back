package DAM.Helper.Flights;

import DAM.Parametrs.Flights.CreateFlightStepFiveGhost;
import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Data
public class CreateFlightStepFiveGhostWithPolling {
    String flightStepFiveGhostWithPolling;

    public CreateFlightStepFiveGhostWithPolling() throws JSONException {
        ArrayList<String> ids = new GetPlacementId().getIds();
        String body = new CreateFlightStepFiveGhost().getFlightHideableTypeWithPolling();
        Specification.installSpec(Specification.requestFlight(), Specification.responseSpec200());

        Response response = given().body(body).queryParam("placementId", ids.get(1)).when()
                .post(ids.get(0) + "/creatives").then().extract().response();

        if((Boolean) response.path("pages[0].showCross")) {
            flightStepFiveGhostWithPolling = response.path("pages[0].hideableType");
        }
    }
}

package DAM.Helper.Flights;

import DAM.Parametrs.Flights.CreateFlightStepFivePreroll;
import DAM.Specification;
import io.restassured.response.Response;
import org.json.JSONException;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;

public class CreateFlightStepFivePrerollWithOutPolling {
    String flightStepFivePrerollWithOutPolling;

    public CreateFlightStepFivePrerollWithOutPolling() throws JSONException {
        String[] ids = new GetPlacementId().getIds();
        String body = new CreateFlightStepFivePreroll().getFlightHideableTypeWithOutPolling();
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
            flightStepFivePrerollWithOutPolling = pages.get("hideableType").toString();
        }
    }

    public String getFlightStepFivePrerollWithOutPolling() {
        return flightStepFivePrerollWithOutPolling;
    }
}

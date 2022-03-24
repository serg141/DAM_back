package DAM.Helper.Flights;

import DAM.Parametrs.Flights.CreateFlightStepFiveSlider;
import DAM.Specification;
import io.restassured.response.Response;
import org.json.JSONException;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;

public class CreateFlightStepFiveSliderWithOutPolling {
    String flightStepFiveSliderWithOutPolling;

    public CreateFlightStepFiveSliderWithOutPolling() throws JSONException {
        String[] ids = new GetPlacementId().getIds();
        String body = new CreateFlightStepFiveSlider().getFlightHideableTypeWithOutPolling();
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
            flightStepFiveSliderWithOutPolling = pages.get("hideableType").toString();
        }
    }

    public String getFlightStepFiveSliderWithOutPolling() {
        return flightStepFiveSliderWithOutPolling;
    }
}

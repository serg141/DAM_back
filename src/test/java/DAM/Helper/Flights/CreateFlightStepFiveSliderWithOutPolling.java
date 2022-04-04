package DAM.Helper.Flights;

import DAM.Parametrs.Flights.CreateFlightStepFiveSlider;
import DAM.Specification;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;

@Data
public class CreateFlightStepFiveSliderWithOutPolling {
    String flightStepFiveSliderWithOutPolling;

    public CreateFlightStepFiveSliderWithOutPolling() throws JSONException {
        ArrayList<String> ids = new GetPlacementId().getIds();
        String body = new CreateFlightStepFiveSlider().getFlightHideableTypeWithOutPolling();
        Specification.installSpec(Specification.requestFlight(), Specification.responseSpec200());

        Response response = given().body(body).queryParam("placementId", ids.get(1))
                .when().post(ids.get(0) + "/creatives").then().extract().response();

        LinkedHashMap<String,Object> pages = response.path("pages[0]");

        if((Boolean) pages.get("showCross")) {
            flightStepFiveSliderWithOutPolling = pages.get("hideableType").toString();
        }
    }
}
